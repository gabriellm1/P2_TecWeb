<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Criando Cards</title>
		  <link rel = "stylesheet"
			type ="text/css"
			href = "Form.css"
    />
	</head>
  <body>
  

  <div class="sidenav">
    
     <h3>NBA Calendar</h3>
     <%@ page import = "org.jsoup.Jsoup,org.jsoup.nodes.Document,org.jsoup.nodes.Element,org.jsoup.select.Elements,java.io.IOException,java.util.ArrayList,java.util.List,java.util.Scanner"
		%>
    
    <form action="notas" method="post">
       <br>
      <select onchange="valT()"  name="nome" id="chooseTeam" onclick>
        </select>     
        
        <% 
	  	  Document doc;
	
	      	doc = Jsoup.connect("http://www.nba.com/teams").get(); // NAME
	          Elements names = doc.select("div.team__list a");
	        
	          ArrayList<String> teams = new ArrayList<String>();
	
	          for (Element name : names) {
	        	  teams.add(name.text());
		          }    
        %>
        
       <script>
         
		function valT()
		 {
		     var time = document.getElementById("chooseTeam").value;
			let uid = document.getElementById("uid").value;
			redirect: window.location.replace("/NoteBlock/notas"+"?uid="+uid+"&time="+time)
					}
		     
		
       
        var arr = [<% for (int i = 0; i < teams.size(); i++) { %>"<%= teams.get(i) %>"<%= i + 1 < teams.size() ? ",":"" %><% } %>];
            var select = document.getElementById("chooseTeam"),arr;
             
             for(var i = 0; i < arr.length; i++)
             {
                 var option = document.createElement("OPTION"),
                     txt = document.createTextNode(arr[i]);
                 option.appendChild(txt);
                 option.setAttribute("value",arr[i]);
                 select.insertBefore(option,select.lastChild);
             }
             
        </script>
         <br>
		<select onchange="valM()" name="match" id="match">
            <option value="Jogo">Jogo</option>
        </select>  
         <%
         	String e = request.getParameter("time");
			if(request.getParameter("time")==null){
				e = "Cleveland Cavaliers";
			}

	        String lName = e.toLowerCase();
	        String lastName = lName.substring(lName.lastIndexOf(" ")+1);
        
        	doc = Jsoup.connect("http://www.nba.com/"+lastName+"/schedule").get(); //DATE
        
	        Elements links = doc.select("span.date.etowah-schedule__event_datetime__date.etowah-schedule__event--game__datetime__date");
	        Elements descri = doc.select("span.element-invisible");
	        Elements opponent = doc.select("div.etowah-schedule__event__opponent-logo img");
	        
	        List<String> matches = new ArrayList<String>();
            List<String> descriL = new ArrayList<String>();
            List<String> dateL = new ArrayList<String>();


            for (int d=4; d<=40+4; d+=2) {  
            	String desc = descri.get(d).text();
            	descriL.add(desc);
			}
            
            for (int i=0; i<=20; i++) {  
            	if (links.size()!=0) {
	            	String  date = links.get(i).text().substring(links.get(i).text().lastIndexOf(" ")-3);
	            	dateL.add(date);
	            	String opp =  opponent.get(i).attr("alt");
	            	String desc = descriL.get(i);

					String ma = ("Contra "+opp+" em : "+date);
					matches.add(ma);
				}
            }
	     %>
        <script>
        
	    	var a = "<%= e %>";
            document.getElementById('chooseTeam').value = a;
	    	var e = document.getElementById("chooseTeam");
	    	var strUser = e.options[e.selectedIndex].text;
	    	console.log(strUser);
	    	console.log(a)
	    	
	    	var arrMa = [<% for (int i = 0; i < matches.size(); i++) { %>"<%= matches.get(i) %>"<%= i + 1 < matches.size() ? ",":"" %><% } %>];

            var select = document.getElementById("match"),arrMa;
            
             for(var i = 0; i < arrMa.length; i++)
             {
                 var option = document.createElement("OPTION"),
                 txt = document.createTextNode(arrMa[i]);
                 option.appendChild(txt);
                 option.setAttribute("value",arrMa[i]);
                 select.insertBefore(option,select.lastChild);
             }
             
        </script>    
      
      
        <br>
        
        <script>
        
	       function valM() {
	    	    var d = document.getElementById("match").value;
	    	    var index = arrMa.indexOf(d); 
		    	var arrDe = [<% for (int i = 0; i < descriL.size(); i++) { %>"<%= descriL.get(i) %>"<%= i + 1 < descriL.size() ? ",":"" %><% } %>];
		    	var arrDt = [<% for (int i = 0; i < dateL.size(); i++) { %>"<%= dateL.get(i) %>"<%= i + 1 < dateL.size() ? ",":"" %><% } %>];

	    	    var desc = arrDe[index];
	    	    var date = arrDt[index];
	    	    document.getElementById('descri').value = desc;
	    	    var months = ["Jan","Fev","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"];
	    	    var n = date.split(" ");
	    	    var day =  n[1];
	    	    var mon = months.indexOf(n[0])+1;
	    	    if(parseInt(mon, 10)<10){
	    	    	mon = "0"+mon;
	    	    }
	    	    var cDate = "2018-"+mon+"-"+day;
	    	    document.getElementById('myDate').value = cDate;
	    	}
	       
		</script>
        
        <textarea name = "descri" id="descri" rows="10" cols="24">Sobre o Jogo ...</textarea>
        
        <input type="date" id="myDate" name="data" value="Data">
        
        <input style="display: none" type="text" name="uid" value="<%=request.getAttribute("uid")%>">
        <input type="submit" name="Save" class="form form-Save" value="Adicionar"> 
      </form>
      
      

  
<style>
body {font-family: Arial, Helvetica, sans-serif;}
* {box-sizing: border-box;}
/* Button used to open the contact form - fixed at the bottom of the page */
.config-button {
  color: white;
  padding: 0px 20px;
  border: none;
  cursor: pointer;
  opacity: 0.8;
  position: fixed;
  bottom: 23px;
  left: 0%;
}
.filter-button {
  color: white;
  padding: 16px 20px;
  border: none;
  cursor: pointer;
  opacity: 0.8;
  position: fixed;
  bottom: 23px;
  left: 9%;
}
/* The popup form - hidden by default */
.form-popup {
  display: none;
  position: fixed;
  bottom: 0;
  left: 15px;
  border: 3px solid #f1f1f1;
  z-index: 9;
    background-color: white;
  
}
/* Add styles to the form container */
.form-container {
  max-width: 300px;
  padding: 10px;
  background-color: white;
}
/* Full-width input fields */
/* Set a style for the submit/login button */
.form-container .btn {
  background-color: #4CAF50;
  color: white;
  padding: 16px 20px;
  border: none;
  cursor: pointer;
  width: 100%;
  margin-bottom:10px;
  opacity: 0.8;
}
/* Add a red background color to the cancel button */
.form-container .btn-cancel {
  background-color: red;
  color:red
}
/* Add some hover effects to buttons */
.form-container .btn:hover, .open-button:hover {
  opacity: 1;
}
</style>

<input type="image" src="https://image.flaticon.com/icons/svg/61/61094.svg" width="68" height="68" class="config-button" onclick="openForm()"></input>

<div class="form-popup" id="myForm">
  <form action ="Config" class="form-container">
    <h1>Configurações</h1>
    


	<form>
		<input style="display: none" type="text" name="uid" value="<%=request.getAttribute("uid")%>">
		
	</form>

	<form >
    	<input type="button" name="sair" class="form form-Save" value="Sair"  onclick="window.location='home';">
    </form>

      <form action="dados" method="get">
          <input style="display: none" type="text" name="uid" value="<%=request.getAttribute("uid")%>">
	      <input type="submit" class="form form-Save" value="Editar" >
      </form> 
    <button type="button" class="btn-cancel" onclick="closeForm()">X</button>
  </form>
</div>

<script>
function openForm() {
    document.getElementById("myForm").style.display = "block";
}

function closeForm() {
    document.getElementById("myForm").style.display = "none";
}

function dadosuser(){
	let uid = document.getElementById("uid").value
	let noteid = document.getElementById("noteid").value


	
	data = {
		"id":noteid,
		"uid":uid
	};

	fetch("/NoteBlock/notas",{
		method: "delete",
		body: JSON.stringify(data)})   
		
		.then(function(response) {
				  response.text().then(function(data) {
					  redirect: window.location.replace(data+"?uid="+uid)
					  });
				}	
)
		
}




</script>
 
</div>



</body>
  
  <div class="main">
      <section class="card-container">
      
				<%@ page import="java.util.*,br.insper.noteblock.model.*" %>
		<table border='1'>
		<%  
		DAO dao = new DAO();
		 List<Notas> Notas = dao.getLista();
		 for (Notas nota : Notas ) {
			 if(nota.getIduser().equals(Integer.parseInt((String)request.getAttribute("uid")))){%>

			  <article class="card">
              	<header class="card__title">
                  	<h3><%=nota.getNome()%></h3>
                  	<h6><%=nota.getDescri()%></h6>
                  	<h5><%=nota.getData().getTime()%></h5>
              	</header>
              
              	<main class="card__description">
                  
              	</main>
           
					<!-- deletar nota -->
              	    <input style="display: none" type="text" name="uid" id="uid" value="<%=request.getAttribute("uid")%>">
              		<input style="display: none" type="text" name="id" id="noteid" value="<%=nota.getId()%>">
              		<input type="submit" value="Delete" onclick=dadosuser() >
              		<!-- deletar compartilhar nota -->
              		<input type="submit" value="Compartilhar" onclick=dadosuser() >

          		</article>
		<% }} %>
		</table>

      </section>
  </div>
 

</body>
</html>