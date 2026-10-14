import spock.lang.Specification

class BoletimSpec extends Specification {

    def "verifica medias e classificacoes"() {
        given:
        def alunos = [
            "Ana"  : [8.0, 7.5, 9.0],
            "Bruno": [5.0, 6.0, 7.0],
            "Carla": [10.0, 4.0, 7.0],
            "Diego": [3.0, 9.0, 9.0],
        ]

        when:
        def resultados = [:]
        alunos.each { nome, notas ->
            def media = notas.sum() / notas.size()
            def situacao = media >= 7.0 ? "Aprovado" : (media >= 6.5 ? "Recuperação" : "Reprovado")
            resultados[nome] = [media: media, situacao: situacao]
        }

        then:
        Math.abs(resultados["Ana"]["media"] - 8.166666666666666) < 0.0000000001
        resultados["Ana"]["situacao"] == "Aprovado"
        resultados["Bruno"]["media"] == 6.0
        resultados["Bruno"]["situacao"] == "Reprovado"
        resultados["Carla"]["media"] == 7.0
        resultados["Carla"]["situacao"] == "Aprovado"
        resultados["Diego"]["media"] == 7.0
        resultados["Diego"]["situacao"] == "Aprovado"
    }
}
