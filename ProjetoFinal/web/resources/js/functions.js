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
    window.alert("OI");
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
    window.alert(texto);
    document.getElementById("textArea").value = texto;
}




