public class ParadigmaOO{
    public static class Carro{
        private final int maxP = 5;
        private int p = 0;
        private String modelo;
        
        public Carro(String modelo){
            this.p = 1;
            this.modelo = modelo;
        }
        
        private String getModelo(){ return modelo; }
        private int getP(){ return p; }
        private void setP(int quant){ this.p += quant; }
        private int getMaxP(){ return maxP; }
        
        public void addP(int quant){
            if( ( getP() + quant ) <= maxP ){
                setP( quant );
                return;
            }
            
            System.out.println( String.format( "Sem espaco (%d/%d)!!", 
                    getP(), getMaxP() ) );
        }
        
        public void removeP(int quant){
            if( ( getP() - quant ) >= 1 ){
                setP( -quant );
                return;
            }
            
            System.out.println( String.format( "O motorista deve ficar (%d/%d)!!", 
                    getP(), getMaxP() ) );
        }
        
        @Override
        public String toString(){
            return String.format( "O carro %s possui %d/%d pessoas.", 
                    getModelo(), getP(), getMaxP() );
        }
    }
    
    
    public static void main(String[] args){
        Carro fiesta = new Carro( "Fiesta" );
        
        // Depois da criação
        System.out.println( fiesta.toString() );
        
        // Colocando o acompanhante e mais duas pessoas
        fiesta.addP( 4 );
        System.out.println( fiesta.toString() );
        
        // Removendo pessoas;
        fiesta.removeP( 2 );
        System.out.println( fiesta.toString() );
        
    }
}