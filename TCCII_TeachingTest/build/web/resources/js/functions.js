/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var id = 0;

function atualizarQuestao( texto, questaoId ){
    document.getElementById("textArea").style = "display: anything";
    document.getElementById("btnClasseRef").style = "display: anything";
    document.getElementById("btnIniciar").style = "display: anything";
    document.getElementById("textArea").value = texto;
    setQuestaoId(questaoId);
    document.getElementById("idSelecionado").value = id;
    
}

function setQuestaoId( questaoId ){
    id = questaoId;
}

function getQuestaoId(){
    document.getElementById("idSelecionado").value = id;
    i = document.getElementById("idSelecionado").value;
    window.alert(1);
}

function test(){
    window.alert(id);
    i = 0;
    document.getElementById("idSelecionado").value = id;
    //i = document.getElementById("idSelecionado").value;
    window.alert(i);
}

function verQuestao( texto ){
    //window.alert(texto);
    document.getElementById("textArea").value = texto;
}

function mostrarCodigo(){
    document.getElementById('link').click();
}


function mostrarClasseReferencia(){
    window.open('classeReferencia.xhtml','Classe de Referência', "status=no, width=390, height=480");
}

function mostrarClasseJUnit(){
    window.open('classeJUnit.xhtml','Classe JUnit', "status=no, width=600, height=480");
}



