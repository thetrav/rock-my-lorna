<%@ page contentType="text/html;charset=UTF-8" %>
<html>
   <head>
     <title>Lorna rocking EVERYTHING!</title>
      <link href="${createLinkTo(dir:'css',file:'main.css')}" rel="stylesheet">
   </head>
   <body>
      <h1>LORNA ROCKING EVERYTHING!!!</h1>
      <ul class="gallery">
         <g:each in="${guids}" var="guid">
            <li>
               <g:img dir="/image/" file="${guid}.gif" alt="Lorna rocking it"/>
            </li>
         </g:each>
      </ul>

   <div class="button">
      <a href="${createLinkTo(dir:'/',file:'')}" >Make One!</a>
   </div>

  </body>
</html>