$(function() {
   console.log("onload");
   $("#cursor").draggable({
      containment: "parent",
      stop: function(e, ui) {
         $("#x").val(ui.position.left);
         $("#y").val(ui.position.top);
      }
   });

   $('#background-file').change(function() {
      var file = $('#background-file')[0].files[0];
      if(file) {
        var blobURLref = (window.webkitURL ? webkitURL : URL).createObjectURL(file);
        $('#background-img').attr('src', blobURLref);
        $('#canvas').css("display", "block");
        $('#submit-button').css("display", "inline-block");
        $('#file-label').text("Change Image");
      }
   });
});