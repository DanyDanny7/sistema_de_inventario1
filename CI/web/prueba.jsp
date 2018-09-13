<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>fadeOut demo</title>
  <style>
  p {
    font-size: 150%;
    cursor: pointer;
  }
  </style>
  <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
</head>
<body>
 
<p>
  If you click on this paragraph
  you'll see it just fade away.
</p>


<%-- <script>
$( "p" ).click(function() {
  $( "p" ).fadeOut( "slow" );
});
</script> --%>
<script>
setTimeout(function(){
    $("p").fadeOut("slow");
},3000);
</script>
 
</body>
</html>