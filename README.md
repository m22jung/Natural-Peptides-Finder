# Natural-Peptides-Finder
A bioinformatics application that calculates the quality score of a protein peptide sequence.
The algorithm scores a peptide higher if 3-mers from the peptide is a substring of a real biology protein peptide sequence.

- parafile.txt is a fasta file of sample natural pepties from uniprot/swissprot protein sequence database
- extract peptides sequecnes(peptides.txt) from the fasta file(parafile.txt) using fastaToPep.java
- modify peptides sequences(peptides.txt) to have only 20 common amino acids for simplicity using fastaTopepCommon.java
- create random peptides from peptidesCommon.txt by shuffling natural peptides using Shuffle.java.
- natNrand.txt contains natural peptides and random peptides where natural peptides appears first and shuffled sequence is the next line.
- Use Merfile.java to create list of 3-mer occurences for both natural and random peptides. (3merNat.txt & 3merRan.txt)
- Main.java receives a single text file as a input where each line has an ID and one peptide sequence.
