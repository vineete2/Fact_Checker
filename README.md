# Fact_Checker  [![Build Status](https://travis-ci.org/SmartBV2/Fact_Checker.svg?branch=master)](https://travis-ci.org/SmartBV2/Fact_Checker)
A repository for the SNLP course's mini-project - CS Uni Paderborn 

## Project Board: 

URL: https://github.com/orgs/SmartBV2/projects/1

## Goal:
Build a fact-checking engine, which returns a confidence value between -1 [False] and 1 [True] given a fact from DBpedia.

### Steps:
+ Corpus creation 
+ Corpus analysis 
  + Named Entity Extraction 
  + Entity Disambiguation 
  + Relation Extraction 
  
## Implementation Approaches:

#### Naive 
+ Corpus creation: New York Times 2013 Headlines
+ Corpus analysis: FOX 

Result: Having issues with dealing FOX tool in December 2017, gave up.

#### Graph DB

Inspiration from "Computational fact checking from knowledge networks" paper.

+ Corpus analysis: Neo4J 

#### Statistical NLP

+ Corpus creation: On the fly build up.
+ Corpus analysis: Hits_Algo 
