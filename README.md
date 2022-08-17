# Hearst-Patterns
2 parts project who focus on the detection and extraction of hypernyms and hyponyms.

Hypernymy (also called IS-A relation) is a semantic relation between two noun phrases, hypernym and hyponym, such that the hyponym is a subtype of the hypernym. For example, cat and dog are hyponym of animal because they are types of animals. Hypernym relations are hierarchical, so a word can have multiple hypernyms. For example, dog is a hyponym of animal, canine and mammal.

-------------------------------------------
Hypernym relations are important and fundamental for many tasks. To illustrate that, let's consider the following question-answering example:

Document: 
After eating a delicious meal, Yossi took a dessert made of banana.

Question:
Which fruit did Yossi eat

-------------------------------------------


Knowing that banana is a fruit can help an automatic system for question answering to answer correctly the answer banana and not meal.

However, annotating such relations across all possible pairs of words is not feasible. Therefore, many methods have been developed in the last decades in order to automatically construct a database of hypernym relations from large corpora.

The task was to:
1. Construct a database of hypernym relations.
2. Hypernym discovery threw the database.

