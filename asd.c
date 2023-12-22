#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAXG 50
#define MAXBIG 200
#define MAX_CLASSIFICACOES 10
   
typedef struct {
    int avaliacao;
    char nome[MAXG];
    char email [MAXG];
}Classificacao;

typedef struct {
    char nif[MAXG];
    char nome[MAXG];
    char categoria[MAXG];
    char ramo[MAXG];
    char rua[MAXBIG];
    char localidade[MAXG];
    char codigoPostal[MAXG];
    int estado;
    int nClassificacoes;
    int maxClassificacoes;
    Classificacao *classis;
}Empresa;    
    
typedef struct {
    int contador;
    int alocadas;
    Empresa *empresas;
}Empresas;

void classificarEmpresa(Empresas *catalogo) {
    char nif[MAXG];
    int avaliacao;
    Classificacao novaClassificacao;

    // Solicita o NIF da empresa a ser classificada
    printf("NIF da empresa a ser classificada: ");
    scanf("%s", nif);

    // Procura a empresa no catálogo
    for(int i = 0; i < catalogo->contador; i++) {
        if(strcmp(catalogo->empresas[i].nif, nif) == 0) {
            // Solicita a avaliação do usuário
            do {
                printf("Avaliacao (0-5): ");
                scanf("%d", &avaliacao);
            } while(avaliacao < 0 || avaliacao > 5);
			printf("%d   %d\n", catalogo->empresas[i].nClassificacoes,catalogo->empresas[i].nClassificacoes);

            // Verifica se o número de classificações atingiu o limite atualmente alocado
            if (catalogo->empresas[i].nClassificacoes == catalogo->empresas[i].maxClassificacoes) {
                // Se o limite for atingido, aloca mais espaço
				printf("here\n");
                catalogo->empresas[i].maxClassificacoes += MAX_CLASSIFICACOES;
                Classificacao *temp = realloc(catalogo->empresas[i].classis, catalogo->empresas[i].maxClassificacoes * sizeof(Classificacao));
                
                if(temp == NULL) {
                    printf("Erro na alocacao de memoria.\n");
                    return;
                }
                
                catalogo->empresas[i].classis = temp;
            }

            // Adiciona a avaliação à lista de classificações da empresa
            novaClassificacao.avaliacao = avaliacao;
            catalogo->empresas[i].classis[catalogo->empresas[i].nClassificacoes] = novaClassificacao;
            catalogo->empresas[i].nClassificacoes++;

            printf("Avaliacao adicionada com sucesso!\n");
            return;
        }
    }

    printf("Empresa nao encontrada.\n");
}

void criarEmpresa(Empresas *catalogo) {
    // Verifica se o número de empresas atingiu o limite atualmente alocado
    if (catalogo->contador == catalogo->alocadas) {
        // Se o limite for atingido, aloca mais espaço
        catalogo->alocadas += 10; 
        catalogo->empresas = realloc(catalogo->empresas, catalogo->alocadas * sizeof(Empresa));
    }

    Empresa novaEmpresa;

        printf("Nif da empresa: ");
        scanf("%s", novaEmpresa.nif);

    // Solicita o nome da empresa
    printf("Nome da empresa: ");
    scanf(" %[^\n]", novaEmpresa.nome);

        printf("Categoria da empresa(Micro, PME ou GrandeEmpresa): ");
        scanf("%s", novaEmpresa.categoria);
    
    // Solicita a rua da empresa
    printf("Rua da empresa: ");
    scanf(" %[^\n]", novaEmpresa.rua);
    // Solicita a localidade da empresa
    printf("Localidade da empresa: ");
    scanf("%s", novaEmpresa.localidade);
    
        printf("Codigo postal da empresa: ");
        scanf("%s", novaEmpresa.codigoPostal);

       
    // Define o estado da empresa como ativo
    novaEmpresa.estado = 1;
    
    // Adiciona a nova empresa ao catálogo
    catalogo->empresas[catalogo->contador] = novaEmpresa;
    catalogo->contador++;
    
    // Inicializa o array de classificações
    novaEmpresa.nClassificacoes = 0;
    novaEmpresa.maxClassificacoes = MAX_CLASSIFICACOES;
    novaEmpresa.classis = malloc(novaEmpresa.maxClassificacoes * sizeof(Classificacao));
	printf("%p\n", novaEmpresa.classis);
    
    // Informa ao usuário que a empresa foi criada com sucesso
    printf("Empresa criada com sucesso!\n");
}

int main() {
    
    // Inicializa o catálogo de empresas
    Empresas Empresa = {.contador = 0};
    
    int opc;
    do {
        // Mostra o menu principal
        printf("1-Create company\n");
        printf("2-Evaluation\n");
        printf("3-Leave\n");
        scanf("%d", &opc);
        switch (opc) {
            case 1:
                criarEmpresa(&Empresa);
                break;
            case 2:
                classificarEmpresa(&Empresa);
            case 3:
                opc = 4;
                break;
        }
    } while (opc != 4);
}
