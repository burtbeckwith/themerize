package themerize

import static org.codehaus.groovy.grails.io.support.GrailsResourceUtils.appendPiecesForUri

import org.codehaus.groovy.grails.web.pages.discovery.GrailsConventionGroovyPageLocator

class ButtonsTagLib extends AbstractTaglib {

    /**
     * Renderiza um botão do tipo submit
     *
     * @attr REQUIRED action Action a ser chamada
     * @attr id ID do elemento DOM
     * @attr class Classe de estilo a ser aplicada
     * @attr style Estilo a ser aplicado
     * @attr value Texto do botão
     * @attr title Texto alternativo do botão
     */
    def submitButton = {attrs, body ->
        def template = getTemplatePath('buttons/submitButton')
        attrs.name = "_action_${attrs.remove('action')}"
        out << render(template: template.path, model: [attrs: attrs, body: body], plugin: template.plugin)
    }

    /**
     * Renderiza um botão do tipo reset
     */
    def resetButton = {attrs, body ->
        def template = getTemplatePath('buttons/resetButton')
        out << render(template: template.path, plugin: template.plugin)
    }

    /**
     * Renderiza um botão do tipo submit
     *
     * @attr REQUIRED action Action a ser chamada
     * @attr id ID do objeto a ser passado para o controlador
     * @attr class Classe de estilo a ser aplicada
     * @attr style Estilo a ser aplicado
     * @attr value Texto do botão
     * @attr controller Controlador para ser chamado
     * @attr action Action para ser chamada
     * @attr link Link para redirecionar
     * @attr type Tipo do botão. Valores possíveis: default, primary, success, warning, danger, info
     * @attr title Texto alternativo do botão
     */
    def linkButton = {attrs, body ->
        def template = getTemplatePath('buttons/linkButton')
        attrs.link = attrs.link ?: createLink(controller: attrs.remove('controller'), action: attrs.remove('action'), id: attrs.remove('id'), params: attrs.remove('params'))
        String value = attrs.remove('value')
        attrs.type = attrs.type ?: 'default'
        out << render(template: template.path, model: [attrs: attrs, body: body, value: value], plugin: template.plugin)
    }
}
