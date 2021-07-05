//def str = {param ->
//	println "Hello ${param}"
//}

//str("silich")

//def sampleText = "12+23423+234234/1231*21342"
//println sampleText.split(/[+-\/*]/)

// /[\/*+-]/ - foaming marks regexp 



def sampleText = "12+23423+234234-1231*21342"
digits = sampleText.split(/\d+/)
operators = sampleText.split(/[+-\/*]/)

println("${digits[1]}")



//case '/': return a.intdiv(b); break
//	x = operators[i] - operators[i++]; break
// /[\/*+-]/ - foaming marks regexp 
