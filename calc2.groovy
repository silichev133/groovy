firstArgument = "2" as int
secondArgument = "3" as int
currentOperator="-"
result=""
expression="(6+10-4)/(1+1*2)+1"
type=true

def toIntOrNull = { it?.isInteger() ? it.toInteger() : null }


def polish (String expression) {
    exit=[];
    operations=[];
    tmpOperator='';
    for( char ch: expression.toCharArray()){
        if(!(ch ==~ /[\+\-\/\*\(\)]/)){
            tmpOperator+=ch;
        }
        else{
            switch(ch){
                case "+":
                    if ( !operations.isEmpty()&&operations.get(operations.size()-1)==~ /[\+\-\/\*]/){
                        if(tmpOperator!=''){
                            exit.add(tmpOperator)
                            tmpOperator='';
                        }
                        exit.add(operations.get(operations.size()-1))
                        operations.set(operations.size()-1,ch)
                    }
                    else{
                        operations.add(ch)
                        if(tmpOperator!=''){
                            exit.add(tmpOperator)
                            tmpOperator='';
                        }

                    }
                    break;
                case "-":
                    if (!operations.isEmpty()&&operations.get(operations.size()-1)==~ /[\+\-\/\*]/){
                        exit.add(tmpOperator)
                        tmpOperator='';
                        exit.add(operations.get(operations.size()-1))
                        operations.set(operations.size()-1,ch)
                    }
                    else{
                        operations.add(ch)
                        if(tmpOperator!=''){
                            exit.add(tmpOperator)
                            tmpOperator='';
                        }
                    }
                    break;
                case "*":
                    if ( !operations.isEmpty()&&operations.get(operations.size()-1)==~ /[\/\*]/){
                        exit.add(tmpOperator)
                        tmpOperator='';
                        exit.add(operations.get(operations.size()-1))
                        operations.set(operations.size()-1,ch)
                    }
                    else{
                        operations.add(ch)
                        if(tmpOperator!=''){
                            exit.add(tmpOperator)
                            tmpOperator='';
                        }
                    }
                    break;
                case "/":
                    if (!operations.isEmpty()&&operations.get(operations.size()-1)==~ /[\/\*]/){
                        exit.add(tmpOperator)
                        tmpOperator='';
                        exit.add(operations.get(operations.size()-1))
                        operations.set(operations.size()-1,ch)
                    }
                    else{
                        operations.add(ch)
                        if(tmpOperator!=''){
                            exit.add(tmpOperator)
                            tmpOperator='';
                        }
                    }
                    break;
                case "(":
                    operations.add(ch)
                    break;
                case ")":
                    if(tmpOperator!=''){
                        exit.add(tmpOperator)
                        tmpOperator='';
                    }
                    while(!(operations.get(operations.size()-1)=="(" )){
                        exit.add(operations.get(operations.size()-1))
                        operations.remove(operations.size()-1)
                    }
                    operations.remove(operations.size()-1)
                    break;
            }
        }
    }
    exit.add(tmpOperator)
    for(int i= operations.size()-1; i>=0; i--){
        exit.add(operations.get(i))
    }
    for(int i=0; i<exit.size();i++){
        System.out.println(exit.get(i));
    }



}
def calc (int firstArgument, int secondArgument,char currentOperator){
    if(!(firstArgument ==~ /((-|\\+)?[0-9]+(\\.[0-9]+)?)+/)){
        type = false;
    }
    if(!(secondArgument ==~ /((-|\\+)?[0-9]+(\\.[0-9]+)?)+/)){
        type = false;
    }
    if (type){
        switch (currentOperator) {
            case "+":
                result ="${firstArgument + secondArgument}";
                System.out.println("Result = " + result);
                break;

            case "-":
                result = "${firstArgument - secondArgument}";
                System.out.println("Result = " + result);
                break;

            case "*":
                result = "${firstArgument * secondArgument}";
                System.out.println("Result = " + result);
                break;
            case "/":
                if (secondArgument == 0) {
                    System.out.println("Error: divide by zero");
                } else {
                    result = "${firstArgument/secondArgument}";
                    System.out.println("Result = " + result);
                }
                break;

            default:
                System.out.println("Error");
                break;

        }
    }
    else{
        System.out.println("Error: NAN");
    }
}
polish(expression)
