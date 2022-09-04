package Main;


public class UsualMatrix {
    protected int rows;
    protected int columns;
    protected int [] [] mat;

    public UsualMatrix (int n_rows, int n_columns){
        rows = n_rows;
        columns = n_columns;
        mat = new int [rows][columns];

    }

    public UsualMatrix sum(UsualMatrix a){


        	if((rows != a.rows) && (columns != a.columns)) {
                IndexOutOfBoundsException e = new IndexOutOfBoundsException("Impossible to sum matrixes of different sizes");
        	    throw e;

        }
        UsualMatrix res = new UsualMatrix(rows, columns);
        UsualMatrix tmp2 = new UsualMatrix(rows, columns);

            for (int i = 0; i < rows; i++)
                for (int j = 0; j < columns; j++)
                    res.set(i,j, get(i,j) + a.get(i,j));



        return res;
    }

    public UsualMatrix product (UsualMatrix a){

        if (this.columns != a.rows){

            IndexOutOfBoundsException e = new IndexOutOfBoundsException("Impossible to multiply such matrixes ");
            throw e;

        }
        UsualMatrix res = new UsualMatrix(rows, columns);


            for (int i = 0; i < rows; i++){
                for (int j = 0; j < columns; j++){
                    res.set(i,j, 0);
                    for(int k = 0; k < columns; k++)
                        res.set(i,j, res.get(i,j) + get(i,k) * a.get(k,j));
                }
            }

        return res;

    }

    public void set (int row, int column, int value){
        mat[row][column] = value;
    }

    public int get (int row, int column){
        return mat[row][column];
    }



    public boolean equals(UsualMatrix a){


            for (int i = 0; i < rows; i++){
                for(int j = 0; j < columns; j++){

                    if(get(i,j) != a.get(i,j))
                        return false;
                }
            }
        return true;
    }




    public String toString(){
        StringBuilder sb = new StringBuilder ();
        for(int i = 0; i < rows; i++){
            sb.append("\n");
            for(int j = 0; j<columns; j++){
                sb.append(get(i,j));
                sb.append(" ");
            }
        }

        String s = sb.toString();
        return s;
    }

    int getRows(){
        return columns;
    }

    int getColumns(){
        return columns;
    }
}