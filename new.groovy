public class ClassWithClosure {
    private int member = 20

    private String method()
    {
        return "hello"
    }

    def publicMethodWithClosure(String name_)
    {
        def localVar = member + 5
        def localVar2 = "Parameter: ${name_}"
        
        return {
            println "${member} ${name_} ${localVar} ${localVar2} ${method()}"
        }
    }
}

ClassWithClosure sample = new ClassWithClosure()
def closureVar = sample.publicMethodWithClosure("Xavier")
closureVar()
