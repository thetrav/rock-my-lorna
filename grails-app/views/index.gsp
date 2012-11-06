<!doctype html>
<html>
	<head>
		<title>Rock My Lorna</title>

      <link href="css/jquery-ui-1.9.1.custom.min.css" rel="stylesheet">
      <link href="css/bootstrap-responsive.css" rel="stylesheet">
      <link href="css/main.css" rel="stylesheet">

      <link rel="shortcut icon" href="images/favicon.ico">
   </head>
	<body>
		<div id="canvas">
         <div id="cursor"><g:img file="spinner.gif" width="50" height="50"/></div>
         <div id="background"><g:img file="grails_logo.png" id="background-img" width="800" height="600"/></div>
		</div>
      <g:uploadForm controller="rock" action="lorna">
         <div>
            <input type="file" name="background-file" id="background-file" >
            <button id="update-button" type="button">update</button>
         </div>
         <div>
            <input name="x" id="x" class="coord" value="0"> <label for="x" >left</label>
            <input name="y" id="y" class="coord" value="0"> <label for="y" >top</label>
            <input type="submit" value="ROCK MY LORNA!" >
         </div>
      </g:uploadForm>

      <script src="js/jquery-1.8.2.min.js"></script>
      <script src="js/jquery-ui-1.9.1.custom.min.js"></script>
      <script src="js/underscore-min.js"></script>
      <script src="js/bootstrap.js"></script>
      <script src="js/application.js"></script>
	</body>
</html>
