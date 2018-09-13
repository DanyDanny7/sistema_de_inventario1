<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Prueba de Alert</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    <script src="http://codeseven.github.com/toastr/toastr.js"></script>
    <link href="http://codeseven.github.com/toastr/toastr.css" rel="stylesheet"/>
    <link href="http://codeseven.github.com/toastr/toastr-responsive.css" rel="stylesheet"/>
    <script type="text/javascript">
        toastr.options = {
              "debug": false,
              "positionClass": "toast-bottom-right",
              "onclick": null,
              "fadeIn": 300,
              "fadeOut": 100,
              "timeOut": 5000,
              "extendedTimeOut": 1000
        }

var showToastrs = false;

function toastrs() {
  if (!showToastrs) {
    toastr.error('Usuario no Registrado', 'Error!');
    toastr.success('Se guardaron los cambios satisfactoriamente', 'Todo en orden');
    toastr.warning('La latencia del server esta aumentando.', 'Alerta!');
  } else {
    toastr.error('no se puede!\'t.', 'Otro error crítico');
  }
}

// Definimos los callback cuando el TOAST le da un fade in/out:
toastr.options.onFadeIn = function() {
  showToastrs = true;
};
toastr.options.onFadeOut = function() {
  showToastrs = false;
};

$(function() {
  $("#clear").on("click", function() {
    // Clears the current list of toasts
    toastr.clear();
  });
  $("#rewind").on("click", function() {
    // show toastrs :)
    toastrs();
  });
});
    </script>
</head>
<body>
    <div class="container">
        
        <br>
        <div class="col-12">
            <input id="clear" type="submit" class="btn btn-success" value="Limpiar notificaciones"><br><br>
            <input id="rewind" type="submit" class="btn btn-info" value="Mostrar notificaciones">
        </div>

    </div>
</body>
</html>