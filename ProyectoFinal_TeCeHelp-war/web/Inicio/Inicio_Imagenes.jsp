<%-- 
    Document   : Inicio_Imagenes
    Created on : 27-abr-2018, 15:52:03
    Author     : Andres
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="../CSS/Style.css" type="text/css>
        <script> src = "script.js"</script>
        <script language="Javascript" type="text/javascript">
            mis_imagenes = new Array("../Imagenes/Data_Center.jpg", "../Imagenes/Monitoreo.jpg", "../Imagenes/Cableado.png")

            mi_imagen = 0
            imgCt = mis_imagenes.length
            function rotacion() {
                if (document.images) {
                    mi_imagen++
                    if (mi_imagen == imgCt) {
                        mi_imagen = 0
                    }
                    document.img_inicio.src = mis_imagenes[mi_imagen]
                    setTimeout("rotacion()", 3 * 1000)
                }
            }
        </script>
    </head>
    <body id="rotar_img" onload="rotacion()">
        <p><img src="../Imagenes/Data_Center.jpg" name="img_inicio" alt="productos" height='510' width='1340'/></p>
    </body>
</html>

