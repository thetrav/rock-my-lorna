<%@ page contentType="text/html;charset=UTF-8" %>
<html>
   <head>
     <title>Look at her go!</title>
   </head>
   <body>
      <h1>LORNA ROCKING IT!!!</h1>
      <g:img dir="/lorna/view/" file="${lorna}" alt="lorna rocking it"/>
   <div class="fb-like" data-href="http://rock-my-lorna.cloudfoundry.com/lorna/view/${lorna}" data-send="false" data-layout="button_count" data-width="450" data-show-faces="false"></div>
   <div id="fb-root"></div>
   <script>(function(d, s, id) {
     var js, fjs = d.getElementsByTagName(s)[0];
     if (d.getElementById(id)) return;
     js = d.createElement(s); js.id = id;
     js.src = "//connect.facebook.net/en_US/all.js#xfbml=1&appId=295216783921940";
     fjs.parentNode.insertBefore(js, fjs);
   }(document, 'script', 'facebook-jssdk'));</script>

   </body>
</html>