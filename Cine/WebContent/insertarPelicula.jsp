<%@ taglib uri="/WEB-INF/struts-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%>

<html:html>
<head>
	<title>Insertar Pelicula</title>
</head>
<body>
    <html:form action="addPelicula.do">
	    titulo: <html:text property="titulo"/>
		<br>
		sinopsis: <html:text property="sinopsis" />
		<br>
		<html:submit>Guardar</html:submit>
		<br>
		<html:errors/>
    </html:form>
</body>
</html:html>
