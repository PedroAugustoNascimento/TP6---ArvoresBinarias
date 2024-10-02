package src;
public class Stack {

        private Node topo;

        public Stack(){
            topo = null;
        }

        public void setNode(Node topo){
            this.topo = topo;
        }

        public Node getNode(){
            return topo;
        }
    
        public boolean empty(){
            return (topo == null);
        }
    
        public void stack(Node c){
            c.setNext(topo);
            topo = c;
        }
    
        public Node unstack(){
            if(empty()){
                System.out.println("Empty stack ");
                return null;
            } else {
                Node aux = topo;
                topo = topo.getNext();;
                aux.setNext(null);
                return aux;
            }
        }
    
        public void print(){
            if(empty()){
                System.out.println("Pilha vazia");
            } else {
                Node aux = topo;
                while (aux != null){
                    System.out.println(aux.getValue());
                    aux.setNext(aux);;
                }
            }
        }
    }

