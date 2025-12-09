<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <body>
                <h2 style="text-align: center;">学生信息表</h2>
                <table border="1" cellpadding="5" cellspacing="0">
                    <tr style="background-color: #f0f0f0;">
                        <th>学号</th>
                        <th>姓名</th>
                        <th>性别</th>
                        <th>职务</th>
                        <th>联系方式</th>
                    </tr>
                    <!-- 按学号升序排序 -->
                    <xsl:for-each select="学生信息/学生">
                        <xsl:sort select="学号" data-type="text" order="ascending"/>
                        <tr>
                            <td><xsl:value-of select="学号"/></td>
                            <td><xsl:value-of select="姓名"/></td>
                            <td><xsl:value-of select="性别"/></td>
                            <td><xsl:value-of select="@职务"/></td>
                            <td><xsl:value-of select="联系方式"/></td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>