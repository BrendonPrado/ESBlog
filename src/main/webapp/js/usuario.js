function deleteUsuario(object,id) {
    $.ajax({url:"/Blog/usuarios",type:"DELETE",data:''+id+'',success:function (resp) {
            var vo = $(object).parent().parent();
            vo.remove();
        }});
    if($("li").length == 0){
        var cont = $(".list").parent().parent();
        cont.remove();
        $("#conteudo").append('<h2 class="is-bold card">Não há usuários cadastrados</h2>');
    }
}





