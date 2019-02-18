var indexTopicos= 0;


function carregaTopicos() {
    $.get("/Blog/topicos?comeco=" + indexTopicos, function (data) {
        var i = 0;
        while (i < 2) {
            if(data.length == i){
                $("#botao-mais-topicos").css({display:"none"});
                $("#topicos-mais").append("<h3 class='title is-h2' style='margin-bottom: 5% ;margin-left: 37%'>Não há mais tópicos </h3>");
                break;
            }else {
                var topico = data[i];
                $("#topicos").append('<li><div class="box" id="topico-novo"><h2 class="title is-h2">' + topico.titulo + '</h2></div></li>');
                var texto_form = topico.txt.split("\n");
                var topico_novo = $("#topico-novo");
                for (x in texto_form) {
                    topico_novo.append('<p>' + texto_form[x] + '</p>');
                }
                topico_novo.append('<span class="tag is-light span-criacao" id="criado-novo"></span>');
                topico_novo.append('<span class="tag is-light span-criacao" id="data-novo"></span>');
                topico_novo.append("<div class='campo-comentarios'><h3 class='is-3'>Comentarios:</h3><ol style='margin-bottom: 5%' id='comentarios-"+topico.id+"'></ol></div>");
                carregaComentarios(topico.id);
                topico_novo.append("<form><label class='label'>Escreva seu comentario<input id='input-comentario-"+topico.id+"' class='input novo-comentario' ><a class='input is-dark' onclick='fazComentario("+topico.id+")' >Comentar</a></label></form>");
                document.getElementById("criado-novo").innerHTML = "criado por: " + topico.usuarioDono.apelido + "";
                document.getElementById("data-novo").innerHTML = "Em: " + topico.dateEhora.dayOfMonth + "/" + topico.dateEhora.month + "/" + topico.dateEhora.year + "  ás: " + topico.dateEhora.hourOfDay + ":" + topico.dateEhora.minute;
                $("#topicos").append('</br></br>');

                i += 1;
                topico_novo.removeAttr("id");
                $("#criado-novo").removeAttr("id");
                $("#data-novo").removeAttr("id");
                indexTopicos+=1;
            }
        }
    });
}



function carregaComentarios(id) {
    var comentario = $("#comentarios-" + id);
    comentario.children().remove();
    $.get("/Blog/comentarios?id=" + id, function (data) {
        for (i = 0; i < data.length; i++) {
            comentario.append("<li class='list-item'>" +
                "<div class='card'>" +
                "<div class='card-header '>"+
                "<p class='card-header-title subtitle'>Apelido: " + data[i].usuarioDonoComentario.apelido +
                "</p>" +
                "</div>"+
                "<div class='card-content'>"+
                data[i].txt  +
                "</div>"+
                "<footer class='card-footer message-header' style='font-size: 1.4ch'>Em:" +
                + data[i].dateEhora.dayOfMonth + "/" + data[i].dateEhora.month +
                "/" + data[i].dateEhora.year + "  ás: " +
                "" + data[i].dateEhora.hourOfDay +
                ":" + data[i].dateEhora.minute +
                "</footer>"+
                "</div>"+
                "</li>")
        }
    });
}


function fazComentario(id) {
    $.post("/Blog/comentarios","id="+id+"&coment="+$("#input-comentario-"+id+"").val(),function (data) {
        $("#input-comentario-"+id+"").val("");
        carregaComentarios(id);
        if(data == "Comentário não feito! Não pode possuir palavrão!")
            alert(data);
        else
            $("#alterar-"+id).remove();

    });

}

document.addEventListener("DOMContentLoaded",carregaTopicos());