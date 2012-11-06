$(function() {
   var cursor = $("#cursor");
   cursor.draggable({
      cursor: "crosshair",
//      cursorAt: { top: 0, left: 0 },
      containment: "parent",
      stop: function(e, ui) {
         $("#x").val(ui.position.left);
         $("#y").val(ui.position.top);
      }
   });


   cursor.resizable({
      aspectRatio: 248.0/446.0
   });

   $('#submit-button').click(function() {
      $('#scale').val(cursor.width()/248.0);
   })

   $('#background-file').change(function() {
      var file = $('#background-file')[0].files[0];
      if(file) {
        var blobURLref = (window.webkitURL ? webkitURL : URL).createObjectURL(file);
        $('#background-img').attr('src', blobURLref);
        $('#submit-block').css("display", "block");
        $('#canvas').css("display", "block");
        $('#file-label').text("Change Image");
      }
   });


});