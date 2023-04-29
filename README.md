# EqualityTextAI
"Artificial Intelligence" that can understand how much one text is equal to another
```Java
 EqualityTextAI ai = new EqualityTextAI("Hello", "Hepolo");
 int percent_of_confidence1 = ai.percent_of_confidence; //The percentage by which artificial intelligence thinks that these texts are equal
 List<Character> same_chars1 = ai.same_chars;//same chars of Hello and Hepolo
 List<Character> not_similar_chars1 = ai.not_same_chars;//non-similar chars of Hello and Hepolo
 int percent_of_confidence2 = ai.refresh("Test", "piece").percent_of_confidence;//The percentage by which artificial intelligence thinks that these texts are equal
 List<Character> same_chars2 = ai.same_chars;//same chars of Test and piece
 List<Character> not_similar_chars2 = ai.not_same_chars;//non-similar chars of Test and piece
 ai.history_of_percent_of_confidence.get(0);//percent_of_confidence1
 ai.history_of_percent_of_confidence.get(1);//percent_of_confidence2
```
