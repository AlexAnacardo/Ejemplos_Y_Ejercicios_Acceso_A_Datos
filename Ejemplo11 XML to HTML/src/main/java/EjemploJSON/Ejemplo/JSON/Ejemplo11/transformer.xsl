<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<!-- TODO: Auto-generated template -->
		<html>
			<head>
				<title>Pagina web transformada de un xml</title>
			</head>
			<body>
				<h1>Jugadores</h1>
				<table border="1">
					<thead>
						<th>Nombre</th>
						<th>Posicion</th>
						<th>Edad</th>
					</thead>
					<tbody>
						<xsl:for-each select="/jugadores/jugador">
							<xsl:choose>
							<xsl:when test="@activo='true'">			
								<tr style='background-color: green'>
									<td>
										<xsl:value-of select="nombre"></xsl:value-of>
									</td>
									<td>
										<xsl:value-of select="posicion"></xsl:value-of>
									</td>
									<td>
										<xsl:value-of select="edad"></xsl:value-of>
									</td>
								</tr>
							</xsl:when>
							<xsl:otherwise>			
								<tr style='background-color: red'>
									<td>
										<xsl:value-of select="nombre"></xsl:value-of>
									</td>
									<td>
										<xsl:value-of select="posicion"></xsl:value-of>
									</td>
									<td>
										<xsl:value-of select="edad"></xsl:value-of>
									</td>
								</tr>
							</xsl:otherwise>
							</xsl:choose>	
						</xsl:for-each>
					</tbody>
				</table>
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>