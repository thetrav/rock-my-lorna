<%@ page contentType="text/html;charset=UTF-8" %>
<html>
   <head>
     <title>Lorna rocking it!</title>
      <link href="${createLinkTo(dir:'css',file:'main.css')}" rel="stylesheet">
   </head>
   <body>
      <h1>LORNA ROCKING IT!!!</h1>
      <g:img dir="/image/" file="${lorna}.gif" alt="lorna rocking it"/>
   <div class="fb-like" data-href="http://rock-my-lorna.cloudfoundry.com/rock/view/${lorna}" data-send="false" data-layout="button_count" data-width="450" data-show-faces="false"></div>
   <div id="fb-root"></div>
   <script>(function(d, s, id) {
     var js, fjs = d.getElementsByTagName(s)[0];
     if (d.getElementById(id)) return;
     js = d.createElement(s); js.id = id;
     js.src = "//connect.facebook.net/en_US/all.js#xfbml=1&appId=295216783921940";
     fjs.parentNode.insertBefore(js, fjs);
   }(document, 'script', 'facebook-jssdk'));</script>

   <div class="button">
      <a href="${createLinkTo(dir:'/',file:'')}" >Go Again!</a>
   </div>

  </body>
</html>