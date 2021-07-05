def calculator = new Calculator()
println(calculator.calculate('1 + 324'))

class Calculator {
    int calculate(String expression) { 
        parse(expression) { a, operator, b ->
            switch(operator) {
                case '-': return a - b; break
                case '+': return a + b; break
                case '*': return a * b; break
                case '/': return a.intdiv(b); break
            }
        }
    }
    
    def parse(expression, c) {
        expression.find(/(\d+)\s*([*\/+-])\s*(\d+)/) { match, left, operator, right ->
            c.call(left.toInteger(), operator, right.toInteger())
        }.toInteger()
    }
    
}
