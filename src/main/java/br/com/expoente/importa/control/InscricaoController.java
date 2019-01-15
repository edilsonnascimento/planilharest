/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.expoente.importa.control;

import br.com.expoente.importa.dao.InscricaoDAO;
import br.com.expoente.importa.entity.Inscricao;
import br.com.expoente.importa.infra.FileSaver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.List;
import javax.ws.rs.core.Request;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author ednascimento
 */
@Controller
@RequestMapping("/importar")
public class InscricaoController {

    @Autowired
    private InscricaoDAO inscricaoDao;

    @Autowired
    private FileSaver fileSaver;

    @RequestMapping(method = RequestMethod.GET)
    public String inscricao() {
        return "/importar/inscricao";
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView importa(MultipartFile arquivo, Integer codigo) throws IOException{

        ModelAndView modelAndView = new ModelAndView("/home");

        File caminhoArquivo = new File("/home/ednascimento/Downloads/" + arquivo.getOriginalFilename());
        
        System.out.println("CAMINHO: " + caminhoArquivo);               
        
        
        processaPlanilha(caminhoArquivo, codigo);
        
        //listar();

        return modelAndView;
    }
    
    private void processaPlanilha(File caminhoArquivo, Integer codigo) throws FileNotFoundException, IOException{
        
        FileInputStream in = new FileInputStream(caminhoArquivo);
        XSSFWorkbook planilha = new XSSFWorkbook(in);
        
         for (int p = 0; p < planilha.getNumberOfSheets(); p++) {             
                XSSFSheet aba = planilha.getSheetAt(p);
                
                try {
                    if (! aba.getRow(7).getCell(0).getStringCellValue().isEmpty()) {
                        System.out.println("IMPORTANDO DADOS DA ABA: " + aba.getSheetName() + "\n");
                    }
                    
                } catch (Exception e) {
                        System.out.println("\n ABA: " + aba.getSheetName() + " ESTA ZERADA\n");                        
                        break;
                }

                for (int i = 7; i <= aba.getLastRowNum(); i++) {
                    if (! aba.getRow(i).getCell(0).getStringCellValue().isEmpty()){
                        Row registro = aba.getRow(i); 
                        Inscricao inscricao = new Inscricao();
                        inscricao.setCod_cliente_sga(codigo);
                        for (int j = 0; j < 4; j++) {

                                Cell celula = registro.getCell(j);

                                switch (celula.getColumnIndex()) {
                                    case 0:
                                        inscricao.setNm_inscrito(celula.getStringCellValue());
                                        break;
                                    case 1:
                                        inscricao.setNm_serie(celula.getStringCellValue());
                                        break;
                                    case 2:
                                        Double d;
                                        if (Cell.CELL_TYPE_STRING != celula.getCellType()) {
                                            d = celula.getNumericCellValue();
                                            inscricao.setNm_turma(d.toString());
                                        } else {
                                            inscricao.setNm_turma(celula.getStringCellValue());
                                        }
                                        break;
                                    case 3:
                                        inscricao.setNm_turno(celula.getStringCellValue());
                                        break;
                                }//case                       
                        }//for
                        inscricaoDao.gravar(inscricao);
                    }//if
                }
            }         
            in.close();
    }
    
    public ModelAndView listar(){
        ModelAndView modelAndView = new ModelAndView("/importar/inscricao");
        
        List<Inscricao> inscricoes = inscricaoDao.listar();
        modelAndView.addObject("inscricoes", inscricoes);
        
        return modelAndView;
    }

}
