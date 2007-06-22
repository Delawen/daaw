<%@ taglib uri="/WEB-INF/struts-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%>

<html:html>
<head>
	<title></title>
</head>
<body>
    <bean:write name="peliculaForm" property="titulo" />
	<bean:write name="pelicula" property="sinopsis" />
</body>
</html:html>
