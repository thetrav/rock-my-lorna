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
      <g:uploadForm controller="rock" action="lorna">
         <div id="canvas" style="display:none">
            <span class="instructions">Drag Lorna To Position then: </span> <input type="submit" id="submit-button" style="display:none" value="ROCK MY LORNA!" >
            <div>
               <div id="cursor"><g:img file="lorna_rockin.gif"/></div>
               <div id="background"><g:img file="select.png" id="background-img"/></div>
            </div>
         </div>
         <div class="file-selector">
            <input type="file" name="background-file" id="background-file" >
            <span id="file-label">Select A File</span>
         </div>
         <div style="display:none">
            <input name="x" id="x" class="coord" value="0"> <label for="x" >left</label>
            <input name="y" id="y" class="coord" value="0"> <label for="y" >top</label>
         </div>
      </g:uploadForm>

      <script src="js/jquery-1.8.2.min.js"></script>
      <script src="js/jquery-ui-1.9.1.custom.min.js"></script>
      <script src="js/underscore-min.js"></script>
      <script src="js/bootstrap.js"></script>
      <script src="js/application.js"></script>
	</body>
</html>
