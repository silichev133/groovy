def expression = System.console().readLine 'Enter expression: '

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


polish(expression)
