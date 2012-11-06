$(function() {
   console.log("onload");
   $("#cursor").draggable({
      containment: "parent",
      stop: function(e, ui) {
         $("#x").val(ui.position.left);
         $("#y").val(ui.position.top);
      }
   });

   $('#update-button').click(function(e) {
//      e.preventDefault();
      console.log("cliked");
      var file = $('#background-file')[0].files[0];
      if(file){
        var blobURLref = (window.webkitURL ? webkitURL : URL).createObjectURL(file);
        $('#background-img').attr('src', blobURLref);
        $('#cursor').css("display", "block");
      }
   });
});