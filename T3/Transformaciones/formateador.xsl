<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <head>
                <title>Peliculas Cartelera</title>
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous"/>
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"/>
                <link
                        rel="stylesheet"
                        href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css"
                />
            </head>
            <body>
                <main class="container">
                    <h1>Transformacion de peliculas</h1>
                    <div>
                        <h2>Transformaciones via XSL - FOREACH</h2>

                            <div class="row">
                                <xsl:for-each select="/peliculas/pelicula">
                                    <div class="col">
                                        <div class="card" style="width: 18rem;">
                                            <img class="card-img-top" alt="...">
                                                <xsl:attribute name="src">
                                                    <xsl:value-of select="@poster"/>
                                                </xsl:attribute>
                                            </img>
                                            <div class="card-body">
                                                <h5 class="card-title"><xsl:value-of select="@titulo"/></h5>
                                                <p class="card-text"><xsl:value-of select="sinopsis"/></p>
                                                <a href="#" class="btn btn-primary">Go somewhere</a>
                                            </div>
                                        </div>
                                    </div>
                                </xsl:for-each>
                            </div>
                    </div>
                </main>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>