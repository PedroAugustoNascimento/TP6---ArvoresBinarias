package src;

public class BinaryTree {
    Node root;
    int count = 0;

    // construtor
    public BinaryTree() {
        root = null;
    }

    // inserir no começo
    // se o elemento for igual, não insere
    private Node insert(Node newNode, Node current) {
        if (current == null)
            return newNode;
        if (current.getValue() > newNode.getValue())
            current.setLeft(insert(newNode, current.getLeft()));
        if (current.getValue() < newNode.getValue())
            current.setRight(insert(newNode, current.getRight()));

        return current;
    }

    // metodo publico para o main
    public void insertAtBegining(Node newNode) {
        root = insert(newNode, root);
    }

    // impressao pre ordem
    private void preorder(Node node) {
        if (node != null) {
            System.out.println("Element: " + node.getValue());
            preorder(node.getLeft()); // E
            preorder(node.getRight()); // D
        }
    }

    // metodo publico
    public void preOrder() {
        preorder(root);
    }

    // impressao pos ordem
    private void posorder(Node node) {
        if (node != null) {
            posorder(node.getLeft()); // E
            posorder(node.getRight()); // D
            System.out.println("Element: " + node.getValue()); // R
        }
    }

    // metodo publico
    public void posOrder() {
        posorder(root);
    }

    // impressao em ordem
    private void onorder(Node node) {
        if (node != null) {
            onorder(node.getLeft()); // E
            System.out.println(node.getValue()); // R
            onorder(node.getRight()); // D
        }
    }

    // metodo publico
    public void onOrder() {
        onorder(root);
    }

    // encontrar pai do elemento
    private Node findNode(Node current, int value) {
        if (current == null)
            return null;

        if (value > current.getValue()) {
            if (current.getRight() != null) {
                if (current.getRight().getValue() == value)
                    return current;
            }
        } else {
            if (current.getLeft() != null) {
                if (current.getLeft().getValue() == value)
                    return current;
            }
        }

        if (current.getValue() > value)
            return findNode(current.getLeft(), value);
        if (current.getValue() < value)
            return findNode(current.getRight(), value);

        return null;
    }

    // remover
    public boolean remove(int value) {
        if (root == null) {
            return false; // Se a árvore está vazia, retorna falso
        }
    
        // Caso especial: se o nó a ser removido é a raiz
        if (root.getValue() == value) {
            if (root.getLeft() == null && root.getRight() == null) {
                root = null; // Remove a raiz se ela não tiver filhos
            } else if (root.getLeft() == null) {
                root = root.getRight(); // Se a raiz não tem filho esquerdo, substitui pelo direito
            } else if (root.getRight() == null) {
                root = root.getLeft(); // Se a raiz não tem filho direito, substitui pelo esquerdo
            } else {
                // A raiz tem dois filhos: encontra o nó mais à esquerda na subárvore direita
                Node fatherRightLeft = farLeftPossible(root, root.getRight());
                Node substitute = fatherRightLeft.getLeft();
                if (substitute == null) {
                    substitute = root.getRight(); // O mais à esquerda pode ser o próprio filho direito da raiz
                } else {
                    fatherRightLeft.setLeft(substitute.getRight()); // Ajusta o filho do pai do substituto
                }
                substitute.setLeft(root.getLeft());
                substitute.setRight(root.getRight());
                root = substitute; // Substitui a raiz pelo nó encontrado
            }
            return true; // Raiz removida
        }
    
        // Para outros casos, encontramos o pai do nó a ser removido
        Node father = findNode(root, value);
        if (father == null) {
            return false; // O valor não foi encontrado
        }
    
        // Determina o nó filho a ser removido (esquerda ou direita do pai)
        Node son;
        if (father.getValue() < value) {
            son = father.getRight();
        } else {
            son = father.getLeft();
        }
    
        // Primeiro caso: se o filho não tem filhos (nó folha)
        if (son.getLeft() == null && son.getRight() == null) {
            if (father.getValue() < value) {
                father.setRight(null);
            } else {
                father.setLeft(null);
            }
            return true;
        }
    
        // Segundo caso: se o filho tem apenas um filho
        if (son.getLeft() == null) {
            if (father.getValue() < value) {
                father.setRight(son.getRight());
            } else {
                father.setLeft(son.getRight());
            }
            return true;
        }
        if (son.getRight() == null) {
            if (father.getValue() < value) {
                father.setRight(son.getLeft());
            } else {
                father.setLeft(son.getLeft());
            }
            return true;
        }
    
        // Terceiro caso: o nó tem dois filhos
        if (son.getLeft() != null && son.getRight() != null) {
            Node fatherRightLeft = farLeftPossible(son, son.getRight());
            Node substitute = fatherRightLeft.getLeft();
            if (substitute == null) {
                substitute = son.getRight(); // O mais à esquerda pode ser o próprio filho direito
            } else {
                fatherRightLeft.setLeft(substitute.getRight()); // Ajusta o filho do pai do substituto
            }
            substitute.setLeft(son.getLeft());
            substitute.setRight(son.getRight());
            if (father.getValue() < value) {
                father.setRight(substitute);
            } else {
                father.setLeft(substitute);
            }
            return true;
        }
    
        return false;
    }
    

    public void removeNum(int value) {
        remove(value);
    }

    // encontrar o no substituto
    private Node farLeftPossible(Node dad, Node son) {
        if (son.getLeft() == null)
            return dad;
        return farLeftPossible(son, son.getLeft());
    }

    // questão 01) Método que conta o número de nós de uma árvore binária
    private int privCountNodes(Node current) {
        if (current == null)
            return count;
        else {
            count++;
            privCountNodes(current.getLeft());
            privCountNodes(current.getRight());
            return count;
        }
    }

    public void countNodes() {
        int nodes = privCountNodes(root);
        System.out.println("Amount nodes : " + nodes);
    }

    // questão 02) Método que conta o número de nós não-folha de uma árvore binária
    private int privNotTerminalNodes(Node current) {
        if (current == null)
            return 0;
        int count = 0;
        if (current.getLeft() != null || current.getRight() != null) {
            count = 1;
        }
        count += privNotTerminalNodes(current.getLeft());
        count += privNotTerminalNodes(current.getRight());
        return count;
    }

    public void countNotTerminalNodes() {
        int nodes = privNotTerminalNodes(root);
        System.out.println("Amount non-Terminal nodes : " + nodes);
    }

    // questão 03)Método que conta o número de nós folhas de uma árvore binária
    private int privTerminalNodes(Node current) {
        if (current == null)
            return 0;
        int count = 0;
        if (current.getLeft() == null && current.getRight() == null)
            count = 1;

        count += privTerminalNodes(current.getLeft());
        count += privTerminalNodes(current.getRight());
        return count;
    }

    public void countTerminalNodes() {
        int nodes = privTerminalNodes(root);
        System.out.println("Amount terminal nodes: " + nodes);
    }

    // questão 04) Método que calcula a altura de uma árvore binária
    private int privHeightTree(Node current) {
        if (current == null)
            return 0;
        int leftcount = 0;
        int rightcount = 0;
        if (current.getLeft() != null) {
            leftcount = 1;
            leftcount += privHeightTree(current.getLeft());
        }
        if (current.getRight() != null) {
            rightcount = 1;
            rightcount += privHeightTree(current.getRight());
        }
        if (rightcount > leftcount)
            return rightcount;
        else {
            return leftcount;
        }
    }

    public void heightTree() {
        int height = privHeightTree(root);
        System.out.println("Height tree: " + height);
    }

    // questão 05) Método que remove todos elementos pares
    private void privRemovePairNumbers(Node current) {
        if(current != null) {
            privRemovePairNumbers(current.getLeft());
            privRemovePairNumbers(current.getRight());
            if (current.getValue() % 2 == 0) {
                remove(current.getValue());
            }
        }
    }

    public void removePairNumbers() {
        privRemovePairNumbers(root);
        System.out.println("Removed");
    }

    // questão 06) Método que faz um espelhamento da árvore
    private boolean privMirroringTree(Node current) {
        if (current == null) {
            return false;
        } else {
            Node right = current.getRight();
            Node left = current.getLeft();
            current.setRight(left);
            current.setLeft(right);
            privMirroringTree(current.getLeft());
            privMirroringTree(current.getRight());
            return true;
        }
    }

    public void mirroringTree() {
        privMirroringTree(root);
        preOrder();
    }

    // questão 07) Método não-recursivo para encaminhamento da árvore
}
