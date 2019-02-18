package br.com.blog.servlet;

import br.com.blog.modelo.Comentario;
import br.com.blog.modelo.Usuario;
import br.com.blog.modelo.dao.ComentarioDao;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ComentarioServlet",urlPatterns = {"/comentarios"},asyncSupported = true)
public class ComentarioServlet extends HttpServlet {
    ComentarioDao comentarioDao = new ComentarioDao();
    Gson gson = new Gson();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String coment = request.getParameter("coment");


        Usuario usuarioDono = (Usuario) request.getSession().getAttribute("usuarioDono");
        Usuario usuarioCadastrado = (Usuario) request.getSession().getAttribute("usuarioCadastrado");
        if ((id != null && coment != null)  && (!ComentarioEhOfensivo(coment))) {
            if (usuarioDono != null) {
                comentarioDao.insertCarregaTopico(Integer.parseInt(id), coment, usuarioDono);
                response.setContentType("application/json");
                response.getWriter().print(gson.toJson("Comentario feito"));
            } else if (usuarioCadastrado != null) {
                comentarioDao.insertCarregaTopico(Integer.parseInt(id), coment, usuarioCadastrado);
                response.setContentType("application/json");
                response.getWriter().print(gson.toJson("Comentario feito"));
            }
        }else {
            response.setContentType("application/json");
            response.getWriter().print(gson.toJson("Comentário não feito! Não pode possuir palavrão!"));
        }
    }

    public boolean ComentarioEhOfensivo(String comment){
        ArrayList palavrasOfensivas = new ArrayList();
        palavrasOfensivas.add("ANUS");
        palavrasOfensivas.add("BABACA");
        palavrasOfensivas.add("BACURA");
        palavrasOfensivas.add("BAGOS");
        palavrasOfensivas.add("BAITOLA");
        palavrasOfensivas.add("BEBUM");
        palavrasOfensivas.add("BESTA");
        palavrasOfensivas.add("BICHA");
        palavrasOfensivas.add("BISCA");
        palavrasOfensivas.add("BIXA");
        palavrasOfensivas.add("BOAZUDA");
        palavrasOfensivas.add("BOCETA");
        palavrasOfensivas.add("BOCO");
        palavrasOfensivas.add("BOC+");
        palavrasOfensivas.add("BOIOLA");
        palavrasOfensivas.add("BOLAGATO");
        palavrasOfensivas.add("BOQUETE");
        palavrasOfensivas.add("BOLCAT");
        palavrasOfensivas.add("BOSSETA");
        palavrasOfensivas.add("BOSTA");
        palavrasOfensivas.add("BOSTANA");
        palavrasOfensivas.add("BRECHA");
        palavrasOfensivas.add("BREXA");
        palavrasOfensivas.add("BRIOCO");
        palavrasOfensivas.add("BRONHA");
        palavrasOfensivas.add("BUCA");
        palavrasOfensivas.add("BUCETA");
        palavrasOfensivas.add("BUNDA");
        palavrasOfensivas.add("BUNDUDA");
        palavrasOfensivas.add("BURRA");
        palavrasOfensivas.add("BURRO");
        palavrasOfensivas.add("BUSSETA");
        palavrasOfensivas.add("CACHORRA");
        palavrasOfensivas.add("CACHORRO");
        palavrasOfensivas.add("CADELA");
        palavrasOfensivas.add("CAGA");
        palavrasOfensivas.add("CAGADO");
        palavrasOfensivas.add("CAGAO");
        palavrasOfensivas.add("CAGONA");
        palavrasOfensivas.add("CANALHA");
        palavrasOfensivas.add("CARALHO");
        palavrasOfensivas.add("CASSETA");
        palavrasOfensivas.add("CASSETE");
        palavrasOfensivas.add("CHECHECA");
        palavrasOfensivas.add("CHERECA");
        palavrasOfensivas.add("CHIBUMBA");
        palavrasOfensivas.add("CHIBUMBO");
        palavrasOfensivas.add("CHIFRUDA");
        palavrasOfensivas.add("CHIFRUDO");
        palavrasOfensivas.add("CHOTA");
        palavrasOfensivas.add("CHOCHOTA");
        palavrasOfensivas.add("CHUPADA");
        palavrasOfensivas.add("CHUPADO");
        palavrasOfensivas.add("CLITORIS");
        palavrasOfensivas.add("CLIT+RIS");
        palavrasOfensivas.add("COCAINA");
        palavrasOfensivas.add("COCA-NA");
        palavrasOfensivas.add("COCO");
        palavrasOfensivas.add("COC+");
        palavrasOfensivas.add("CORNA");
        palavrasOfensivas.add("CORNO");
        palavrasOfensivas.add("CORNUDA");
        palavrasOfensivas.add("CORNUDO");
        palavrasOfensivas.add("CORRUPTA");
        palavrasOfensivas.add("CORRUPTO");
        palavrasOfensivas.add("CRETINA");
        palavrasOfensivas.add("CRETINO");
        palavrasOfensivas.add("CRUZ-CREDO");
        palavrasOfensivas.add("CU");
        palavrasOfensivas.add("C+");
        palavrasOfensivas.add("CULHAO");
        palavrasOfensivas.add("CULH+O");
        palavrasOfensivas.add("CULH+ES");
        palavrasOfensivas.add("CURALHO");
        palavrasOfensivas.add("CUZAO");
        palavrasOfensivas.add("CUZ+O");
        palavrasOfensivas.add("CUZUDA");
        palavrasOfensivas.add("CUZUDO");
        palavrasOfensivas.add("DEBIL");
        palavrasOfensivas.add("DEBILOIDE");
        palavrasOfensivas.add("DEFUNTO");
        palavrasOfensivas.add("DEMONIO");
        palavrasOfensivas.add("DEM+NIO");
        palavrasOfensivas.add("DIFUNTO");
        palavrasOfensivas.add("DOIDA");
        palavrasOfensivas.add("DOIDO");
        palavrasOfensivas.add("EGUA");
        palavrasOfensivas.add("+GUA");
        palavrasOfensivas.add("ESCROTA");
        palavrasOfensivas.add("ESCROTO");
        palavrasOfensivas.add("ESPORRADA");
        palavrasOfensivas.add("ESPORRADO");
        palavrasOfensivas.add("ESPORRO");
        palavrasOfensivas.add("ESP+RRO");
        palavrasOfensivas.add("ESTUPIDA");
        palavrasOfensivas.add("EST+PIDA");
        palavrasOfensivas.add("ESTUPIDEZ");
        palavrasOfensivas.add("ESTUPIDO");
        palavrasOfensivas.add("EST+PIDO");
        palavrasOfensivas.add("FEDIDA");
        palavrasOfensivas.add("FEDIDO");
        palavrasOfensivas.add("FEDOR");
        palavrasOfensivas.add("FEDORENTA");
        palavrasOfensivas.add("FEIA");
        palavrasOfensivas.add("FEIO");
        palavrasOfensivas.add("FEIOSA");
        palavrasOfensivas.add("FEIOSO");
        palavrasOfensivas.add("FEIOZA");
        palavrasOfensivas.add("FEIOZO");
        palavrasOfensivas.add("FELACAO");
        palavrasOfensivas.add("FELAŠ+O");
        palavrasOfensivas.add("FENDA");
        palavrasOfensivas.add("FODA");
        palavrasOfensivas.add("FODAO");
        palavrasOfensivas.add("FOD+O");
        palavrasOfensivas.add("FODE");
        palavrasOfensivas.add("FODIDA");
        palavrasOfensivas.add("FODIDO");
        palavrasOfensivas.add("FORNICA");
        palavrasOfensivas.add("FUDENDO");
        palavrasOfensivas.add("FUDECAO");
        palavrasOfensivas.add("FUDEŠ+O");
        palavrasOfensivas.add("FUDIDA");
        palavrasOfensivas.add("FUDIDO");
        palavrasOfensivas.add("FURADA");
        palavrasOfensivas.add("FURADO");
        palavrasOfensivas.add("FURAO");
        palavrasOfensivas.add("FUR+O");
        palavrasOfensivas.add("FURNICA");
        palavrasOfensivas.add("FURNICAR");
        palavrasOfensivas.add("FURO");
        palavrasOfensivas.add("FURONA");
        palavrasOfensivas.add("GAIATA");
        palavrasOfensivas.add("GAIATO");
        palavrasOfensivas.add("GAY");
        palavrasOfensivas.add("GONORREA");
        palavrasOfensivas.add("GONORREIA");
        palavrasOfensivas.add("GOSMA");
        palavrasOfensivas.add("GOSMENTA");
        palavrasOfensivas.add("GOSMENTO");
        palavrasOfensivas.add("GRELINHO");
        palavrasOfensivas.add("GRELO");
        palavrasOfensivas.add("HOMO-SEXUAL");
        palavrasOfensivas.add("HOMOSEXUAL");
        palavrasOfensivas.add("HOMOSSEXUAL");
        palavrasOfensivas.add("IDIOTA");
        palavrasOfensivas.add("IDIOTICE");
        palavrasOfensivas.add("IMBECIL");
        palavrasOfensivas.add("ISCROTA");
        palavrasOfensivas.add("ISCROTO");
        palavrasOfensivas.add("JAPA");
        palavrasOfensivas.add("LADRA");
        palavrasOfensivas.add("LADRAO");
        palavrasOfensivas.add("LADR+O");
        palavrasOfensivas.add("LADROEIRA");
        palavrasOfensivas.add("LADRONA");
        palavrasOfensivas.add("LALAU");
        palavrasOfensivas.add("LEPROSA");
        palavrasOfensivas.add("LEPROSO");
        palavrasOfensivas.add("LESBICA");
        palavrasOfensivas.add("L+SBICA");
        palavrasOfensivas.add("MACACA");
        palavrasOfensivas.add("MACACO");
        palavrasOfensivas.add("MACHONA");
        palavrasOfensivas.add("MACHORRA");
        palavrasOfensivas.add("MANGUACA");
        palavrasOfensivas.add("MANGUAŠA");
        palavrasOfensivas.add("MASTURBA");
        palavrasOfensivas.add("MELECA");
        palavrasOfensivas.add("MERDA");
        palavrasOfensivas.add("MIJA");
        palavrasOfensivas.add("MIJADA");
        palavrasOfensivas.add("MIJADO");
        palavrasOfensivas.add("MIJO");
        palavrasOfensivas.add("MOCREA");
        palavrasOfensivas.add("MOCR+A");
        palavrasOfensivas.add("MOCREIA");
        palavrasOfensivas.add("MOCR+IA");
        palavrasOfensivas.add("MOLECA");
        palavrasOfensivas.add("MOLEQUE");
        palavrasOfensivas.add("MONDRONGA");
        palavrasOfensivas.add("MONDRONGO");
        palavrasOfensivas.add("NABA");
        palavrasOfensivas.add("NADEGA");
        palavrasOfensivas.add("NOJEIRA");
        palavrasOfensivas.add("NOJENTA");
        palavrasOfensivas.add("NOJENTO");
        palavrasOfensivas.add("NOJO");
        palavrasOfensivas.add("OLHOTA");
        palavrasOfensivas.add("OTARIA");
        palavrasOfensivas.add("OT-RIA");
        palavrasOfensivas.add("OTARIO");
        palavrasOfensivas.add("OT-RIO");
        palavrasOfensivas.add("PACA");
        palavrasOfensivas.add("PASPALHA");
        palavrasOfensivas.add("PASPALHAO");
        palavrasOfensivas.add("PASPALHO");
        palavrasOfensivas.add("PAU ");
        palavrasOfensivas.add("PEIA");
        palavrasOfensivas.add("PEIDO");
        palavrasOfensivas.add("PEMBA");
        palavrasOfensivas.add("PENIS");
        palavrasOfensivas.add("P-NIS");
        palavrasOfensivas.add("PENTELHA");
        palavrasOfensivas.add("PENTELHO");
        palavrasOfensivas.add("PERERECA");
        palavrasOfensivas.add("PERU");
        palavrasOfensivas.add("PER+");
        palavrasOfensivas.add("PICA");
        palavrasOfensivas.add("PICAO");
        palavrasOfensivas.add("PIC+O");
        palavrasOfensivas.add("PILANTRA");
        palavrasOfensivas.add("PIRANHA");
        palavrasOfensivas.add("PIROCA");
        palavrasOfensivas.add("PIROCO");
        palavrasOfensivas.add("PIRU");
        palavrasOfensivas.add("PORRA");
        palavrasOfensivas.add("PREGA");
        palavrasOfensivas.add("PROSTIBULO");
        palavrasOfensivas.add("PROST-BULO");
        palavrasOfensivas.add("PROSTITUTA");
        palavrasOfensivas.add("PROSTITUTO");
        palavrasOfensivas.add("PUNHETA");
        palavrasOfensivas.add("PUNHETAO");
        palavrasOfensivas.add("PUNHET+O");
        palavrasOfensivas.add("PUS");
        palavrasOfensivas.add("PUSTULA");
        palavrasOfensivas.add("P+STULA");
        palavrasOfensivas.add("PUTA");
        palavrasOfensivas.add("PUTO");
        palavrasOfensivas.add("PUXA-SACO");
        palavrasOfensivas.add("PUXASACO");
        palavrasOfensivas.add("RABAO");
        palavrasOfensivas.add("RAB+O");
        palavrasOfensivas.add("RABO");
        palavrasOfensivas.add("RABUDA");
        palavrasOfensivas.add("RABUDAO");
        palavrasOfensivas.add("RABUD+O");
        palavrasOfensivas.add("RABUDO");
        palavrasOfensivas.add("RABUDONA");
        palavrasOfensivas.add("RACHA");
        palavrasOfensivas.add("RACHADA");
        palavrasOfensivas.add("RACHADAO");
        palavrasOfensivas.add("RACHAD+O");
        palavrasOfensivas.add("RACHADINHA");
        palavrasOfensivas.add("RACHADINHO");
        palavrasOfensivas.add("RACHADO");
        palavrasOfensivas.add("RAMELA");
        palavrasOfensivas.add("REMELA");
        palavrasOfensivas.add("RETARDADA");
        palavrasOfensivas.add("RETARDADO");
        palavrasOfensivas.add("RIDICULA");
        palavrasOfensivas.add("RID-CULA");
        palavrasOfensivas.add("ROLA");
        palavrasOfensivas.add("ROLINHA");
        palavrasOfensivas.add("ROSCA");
        palavrasOfensivas.add("SACANA");
        palavrasOfensivas.add("SAFADA");
        palavrasOfensivas.add("SAFADO");
        palavrasOfensivas.add("SAPATAO");
        palavrasOfensivas.add("SAPAT+O");
        palavrasOfensivas.add("SIFILIS");
        palavrasOfensivas.add("S-FILIS");
        palavrasOfensivas.add("SIRIRICA");
        palavrasOfensivas.add("TARADA");
        palavrasOfensivas.add("TARADO");
        palavrasOfensivas.add("");
        palavrasOfensivas.add("TEZ+O");
        palavrasOfensivas.add("TEZUDA");
        palavrasOfensivas.add("TEZUDO");
        palavrasOfensivas.add("TROCHA");
        palavrasOfensivas.add("TROLHA");
        palavrasOfensivas.add("TROUCHA");
        palavrasOfensivas.add("TROUXA");
        palavrasOfensivas.add("TROXA");
        palavrasOfensivas.add("VACA");
        palavrasOfensivas.add("VAGABUNDA");
        palavrasOfensivas.add("VAGABUNDO");
        palavrasOfensivas.add("VAGINA");
        palavrasOfensivas.add("VEADA");
        palavrasOfensivas.add("VEADAO");
        palavrasOfensivas.add("VEAD+O");
        palavrasOfensivas.add("VEADO");
        palavrasOfensivas.add("VIADA");
        palavrasOfensivas.add("VIADO");
        palavrasOfensivas.add("VIADAO");
        palavrasOfensivas.add("VIAD+O");
        palavrasOfensivas.add("XAVASCA");
        palavrasOfensivas.add("XERERECA");
        palavrasOfensivas.add("XEXECA");
        palavrasOfensivas.add("XIBIU");
        palavrasOfensivas.add("XIBUMBA");
        palavrasOfensivas.add("XOTA");
        palavrasOfensivas.add("XOCHOTA");
        palavrasOfensivas.add("XOXOTA");
        palavrasOfensivas.add("XANA");
        palavrasOfensivas.add("XANINHA");

        if(palavrasOfensivas.contains(comment.toUpperCase())){
            return true;
        }else {
            return false;
        }



    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        resp.setContentType("application/json");
        resp.getWriter().print(this.gson.toJson(comentarioDao.CarregaComentariosPorIDTopico(Integer.parseInt(id))));

    }


    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        comentarioDao.deletaPorId(Integer.parseInt(req.getReader().readLine()));
    }
}
