<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<html>
<head>
<title>Lista de Peliculas</title>
</head>
<body>
<logic:empty name="peliculasListForm" property="peliculas">
 		Peliculas no disponibles
 </logic:empty>
 <logic:notEmpty name="peliculasListForm" property="peliculas">
 	<table>
 		<tr>
 			<th>Titulo</th>
 			<th>Sinopsis</th>
 		</tr>
 	<logic:iterate name="peliculasListForm" property="peliculas" id="pelicula">
		<tr>
			<td><bean:write name="pelicula" property="titulo" /></td>
			<td><bean:write name="pelicula" property="sinopsis" /></td>
			<td>
				<html:link action="/editPelicula" paramName="pelicula"  paramProperty="titulo" paramId="titulo">Edit</html:link>
			</td>
		</tr>
 	</logic:iterate>
 	</table>
 </logic:notEmpty>
</body>
</html>