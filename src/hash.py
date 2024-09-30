import random

def createDict(): #criação de um dicionário (tabela de dispersão)
    dict = {
    'chave1': 'valor1',
    'chave2': 'valor2',
    'chave3': 'valor3',
    }
    return dict

def printDictionary(): #imprimindo um dicionário
    dict = createDict()
    print(dict)

def hashFunction(k, m): #função para calcular o valor da chave da tabela de dispersão
    return k % m

def printHash(): #impressão e implementação da tabela de dispersão
    num = 0
    m = 0
    k = 0
    while num<10:
        m = random.randint(2,10)
        k = random.randrange(3,15)
        calc = hashFunction(k, m)
        print(f'Key of HashTable: {calc} ')
        num+=1

printDictionary()
printHash()