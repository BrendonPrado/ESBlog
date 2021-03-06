//uso do jquery
function mostraFormularioNovoTopico() {
    $("#novo-topico").css({display:"block"});
    var botao = $("#botao-hide-topi");
    botao.attr("onClick","escondeFormularioNovoTopico()");
    botao.text("Clique para esconder o formulário!");
}

function escondeFormularioNovoTopico() {
    $("#novo-topico").css({display:"none"});
    var botao = $("#botao-hide-topi");
    botao.attr("onClick","mostraFormularioNovoTopico()");
    botao.text("Adicionar novo tópico");

}

function deleteTopico(object,id) {
    $.ajax({url:"/Blog/topicos",type:"DELETE",data:''+id+'',success:function () {
            var pai = $(object).parent().parent();
            pai.remove();
            indexTopicos-=1
        }});

}




//Aqui o event listener
function postaNovoTopico() {
    var titulo = $("#titulo-novo-topico").val();
    var texto = $("#texto-novo-topico").val();


    if(titulo.trim().length > 0 && texto.trim().length > 0){
        $.post("/Blog/topicos?txt="+texto+"&titulo="+titulo,function (data) {
            alert(data);
        });
        resetaTopicosCarregatodos();
        $("#novo-topico")[0].reset();
        escondeFormularioNovoTopico();
        $("#topicos-mais h3").remove();
        $("#botao-mais-topicos").css({display:"block"});
    }else{
        alert("Por favor o título e o texto devem estar" +
            " com algo");
    }
}
//aumenta de dois em dois
var indexTopicos= 0;

function carregaComentarios(id) {
    var comentario = $("#comentarios-" + id);
    comentario.children().remove();
    $.get("/Blog/comentarios?id=" + id, function (data) {
        if(data!=null){
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
                    data[i].dateEhora.dayOfMonth + "/" + data[i].dateEhora.month +
                    "/" + data[i].dateEhora.year + "  ás: " +
                    "" + data[i].dateEhora.hourOfDay +
                    ":" + data[i].dateEhora.minute +
                    "<a class='delete is-medium is-danger' onclick='deleteComentarios(this,"+data[i].id+")' style='margin-left: 75%;background: rgb(224, 90, 71);'>Remover</a>"+
                    "</footer>"+
                    "</div>"+
                    "</li>")
            }
        }
    });
}

function FormEditarTopicoOff(id) {
    $("#cancelar-alteracao").remove();
    $("#novo-topico")[0].reset();
    escondeFormularioNovoTopico();
    $("#alterar").attr("onclick","postaNovoTopico()");
    $("#alterar").text("Postar");
    $("#alterar").attr("id","postar");
    $("#alterar-"+id).css({display:"block"});
    idTopicoAEditar = null;

}


function resetaTopicosCarregatodos() {
    $("#topicos").children().remove();
    indexTopicos = 0;
    carregaTopicos();


}

function AlterarTopico(id) {
    $.ajax({url:"/Blog/topicos?id="+id+"&txt="+$("#texto-novo-topico").val()+"&titulo="+$("#titulo-novo-topico").val(),type:"PUT",data:'',success:function (data) {
            alert(data);
            FormEditarTopicoOff(id);
            resetaTopicosCarregatodos();
        },error:function (error) {
            alert(error.responseJSON);
            FormEditarTopicoOff;
        }});
}

var idTopicoAEditar = null;
function FormEditarTopicoOn(id) {
    $("#cancelar-alteracao").remove();
    if(idTopicoAEditar !=null){
        $("#alterar-"+idTopicoAEditar).css({display:"block"});
    }
    mostraFormularioNovoTopico();
    console.log(id);
    $.get("/Blog/topicos?id="+id,function (data) {
        $("#titulo-novo-topico").val(data.titulo) ;
        $("#texto-novo-topico").val(data.txt);
        $("#postar").attr("id","alterar");
        $("#alterar").text("Alterar");
        $("#alterar").attr("onclick","AlterarTopico("+id+")");
        idTopicoAEditar = id
        $("#opcoes-novo-topico").append("<button  type='button' class='button is-dark' id='cancelar-alteracao' onclick='FormEditarTopicoOff("+id+")'>Cancelar</button>")
        $("#alterar-"+id).css({display:"none"});
    })
}

function deleteComentarios(object,id){
    $.ajax({url:"/Blog/comentarios",type:"DELETE",data:''+id+'',success:function () {
            var pai = $(object).parent().parent();
            pai.remove();
        }});}

function carregaTopicos() {
    $.get("/Blog/topicos?comeco=" + indexTopicos, function (data) {
        var i = 0;
        while (i < 2) {
            if( data != null && data.length == i){
                $("#botao-mais-topicos").css({display:"none"});
                if($("#nao-ha-mais").length == 0)
                    $("#topicos-mais").append("<h3 class='title is-h2' id='nao-ha-mais' style='margin-bottom: 5% ;margin-left: 37%'>Não há mais tópicos </h3>");
                break;
            }else {
                var topico = data[i];
                if(topico.comentado ==true){
                    $("#topicos").append('<li><div class="box" id="topico-novo"><h2 class="title is-h2">' + topico.titulo + '</h2><div class="is-spaced is-family-monospace"><a style="float: right;" onclick="deleteTopico(this,'+topico.id+')"   class="remove has-text-danger is-right is-small">Remover Tópico</a></div></div></li>');

                }else {
                    $("#topicos").append('<li><div class="box" id="topico-novo"><h2 class="title is-h2">' + topico.titulo + '</h2><div class="is-spaced is-family-monospace"><a style="float: right;" onclick="deleteTopico(this,'+topico.id+')"  class="remove has-text-danger is-right is-small">Remover Tópico</a><a class="is-info" onclick="FormEditarTopicoOn('+topico.id+')" id="alterar-'+topico.id+'" style="float: right">Editar Tópico</a></div></div></li>');
                }
                var texto_form = topico.txt.split("\n");
                var topico_novo = $("#topico-novo");
                for (x in texto_form) {
                    topico_novo.append('<p>' + texto_form[x] + '</p>');
                }
                topico_novo.append('<span class="tag is-light span-criacao" id="criado-novo"></span>');
                topico_novo.append('<span class="tag is-light span-criacao" id="data-novo"></span>');
                topico_novo.append("<div class='campo-comentarios'><h3 class='is-3'>Comentarios:</h3><ol style='margin-bottom: 5%' id='comentarios-"+topico.id+"'></ol></div>");
                carregaComentarios(topico.id);
                topico_novo.append("<label class='label'>Escreva seu comentario<input id='input-comentario-"+topico.id+"' class='input novo-comentario' ><button type='button' class='input is-dark' onclick='fazComentario("+topico.id+")' >Comentar</button></label>");
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

document.addEventListener("DOMContentLoaded",carregaTopicos);


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