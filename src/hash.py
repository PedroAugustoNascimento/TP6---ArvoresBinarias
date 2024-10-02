import random
from collections import OrderedDict
from collections import Counter
from collections import ChainMap
from collections import defaultdict

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

#tabela de dispersão que guarda a ordem em que os elementos foram inseridos
def createOrderedDict():
    dict = OrderedDict()
    dict["chave1"] = 1
    dict["chave2"] = 2
    return dict

def printOrderedDict():
    dict = createOrderedDict()
    print(list(dict.keys()))

#tabela de dispersão que adiciona uma chave a um valor não especificado
def createDefaultDict():
    dict = defaultdict(float)
    return dict

def printDefaultDict():
    dict = createDefaultDict()
    print(dict["valor1"])

#tabela de dispersão que itera um contador a cada vez que o mesmo valor é inserido
def createCounterDict():
    dict = Counter(["valor", "valor", "valor", "valor1"])
    return dict

def printCounterDict():
    dict = createCounterDict()
    print(dict["valor"])

#tabela de dispersão em que valores duplicados não são aceitos
def createSetDict():
    dict = set(["valor", "valor", "valor", "valor1"])
    return dict

def printSetDict():
    dict = createSetDict()
    print(dict)

#tabela de dispersão que une duas. Nesse caso houve a união do primeiro dicionário com este criado no método
def createChainMap():
    auxDict = createDict()  
    secondDict = {"chave5": "valor5"}  #
    dictChainMap = ChainMap(auxDict, secondDict)
    return dictChainMap

def printChainMap():
    dict = createChainMap()
    print(dict)


printDefaultDict()
print("============================")
printOrderedDict()
print("============================")
printDictionary()
print("============================")
printHash()
print("============================")
printCounterDict()
print("============================")
printSetDict()
print("============================")
printChainMap()

