����   4 �  Prompt  java/lang/Object listaComandi Ljava/lang/String; ConstantValue 	|
Lista dei comandi:
c -- Crea una rubrica  (nome della rubrica e max dimensione)
d -- Cancella una rubrica (nome della rubrica da cancellare)
a -- Aggiungi alla rubrica (nome della rubrica e contato da aggiungere)
t -- Cerca nella rubrica per nome (nome della rubrica e prefisso stringa da cercare)
y -- Cerca nella rubrica per email (nome della rubrica e prefisso stringa da cercare)
r -- Rimuovi dalla rubrica per nome(nome della rubrica e prefisso stringa da cancellare)
f -- Rimuovi dalla rubrica per email(nome della rubrica e prefisso stringa da cancellare)
s -- Stampa tutta la rubrica (nome della rubrica da stampare)
e -- Esci
 <init> ()V Code
   
  LineNumberTable LocalVariableTable this LPrompt; main ([Ljava/lang/String;)V
     sceltaComando ()C	    java/lang/System   out Ljava/io/PrintStream;
   " ! java/io/PrintStream # $ println (Ljava/lang/String;)V
  & '  creaRubrica
  ) *  eliminaRubrica
  , -  aggiungi
  / 0  cercaInRubricaPerNome
  2 3  cercaInRubricaPerEMail
  5 6  rimuoviInRubricaPerNome
  8 9  rimuoviInRubricaPerEMail
  ; <  stampaRubrica > 
Esci
 @ java/lang/StringBuilder B 

 ? D 
 $
 ? F G H append (C)Ljava/lang/StringBuilder; J  non � un comando valido.
 ? L G M -(Ljava/lang/String;)Ljava/lang/StringBuilder;
 ? O P Q toString ()Ljava/lang/String; args [Ljava/lang/String; scelta C StackMapTable X 
	Crea una rubrica

  Z [ Q sceltaNomeRubrica ] .	Inserire la dimensione massima della rubrica  _ : 
 a c b jbook/util/Input d e readInt (Ljava/lang/String;)I
 g i h GestioneRubriche ' j (Ljava/lang/String;I)I l  	Crezione annullata, la rubrica  n  e' gia presente
 nome maxDim I fineOperazione t java/lang/String v 
	Cancella una rubrica

 g x y e cancellaRubrica { %	Cancellazione annullata, la rubrica  }  non esiste
  java/lang/Error � KUnresolved compilation problem: 
	Unhandled exception type FormatException

 ~ D � 
	Cerca nella rubrica
 � +	Inserire la voce da cercare nella rubrica 
 a � � � 
readString &(Ljava/lang/String;)Ljava/lang/String;
 g � 0 � ;(Ljava/lang/String;Ljava/lang/String;)Ljava/util/ArrayList;
 g � P � � 	La rubrica  � /	La voce cercata non e' presente nella rubrica 
 � O � java/util/ArrayList trovati Ljava/util/ArrayList; LocalVariableTypeTable !Ljava/util/ArrayList<LContatto;>;
 g � 3 � �  
	Rimuovi dalla rubrica rubrica
 � 8	Inserire la voce da cercare ed eliminare dalla rubrica 
 g � � � cancellaInRubricaPerNome '(Ljava/lang/String;Ljava/lang/String;)Z � $ o la voce cercata non � presente
 rimossi Z
 g � � � cancellaInRubricaPerEMail � 
	Stampa tutta la rubrica
 �  non � presente

 s � � � length ()I �  � vuota
 stampato �   � ,	Inserire il nome della rubrica desiderata: 
 s � � � isEmpty ()Z � /
Inserire un comando(h per la lista comandi) : 
 a � � � readChar (Ljava/lang/String;)C 
SourceFile Prompt.java !                 
      /     *� �                        	      �     ڸ <�     �   a   y   �   �   ~   �   �   �   �   s   �   �   �   �   �   �   �   �   �   �   �   �   �   �   �   �   �� � ���� %��z� (��t� +��n� .��h� 1��b� 4��\� 7��V� :��P� =� �� � ?YA� C� EI� K� N� ��)       b       x  �  �  �  �  �  �  �  �  �  �  �  � ! � " � $ � % � ' � ( � * � + � - �         � R S    � T U  V     � w
 
 '      �     L� W� � YK� ?Y\� C*� K^� K� N� `<*� f=� � � ?Yk� C*� Km� K� N� �           4  5  6 % 7 + 8 0 9 K ;        @ o    % ' p q  + ! r q  V   
 � K s 
 *      �     2� u� � YK*� w<� � � ?Yz� C*� K|� K� N� �           >  ?  @  A  B 1 D       & o     ! r q  V   	 � 1 s 
 -      *      
� ~Y�� ��           I       
 0      �     {� �� � YK*� ?Y�� C*� K^� K� N� �� �L+� F*� �� !� � ?Y�� C*� K|� K� N� � +� � ?Y�� C*� KA� K� N� � � +� �� �       .    V  W  X ) Y - Z 4 [ O \ R ^ m ` p b z d       o o    ) R � �  �     ) R � �  V    � R s �	 
 3      �     {� �� � YK*� ?Y�� C*� K^� K� N� �� �L+� F*� �� !� � ?Y�� C*� K|� K� N� � +� � ?Y�� C*� KA� K� N� � � +� �� �       .    g  h  i ) j - k 4 l O m R o m q p s z u       o o    ) R � �  �     ) R � �  V    � R s �	 
 6      �     I� �� � YK*� ?Y�� C*� K^� K� N� �� �<� � � ?Y�� C*� K�� K� N� �           x  y  z ) { - | H ~       = o    )   � �  V   	 � H s 
 9      �     I� �� � YK*� ?Y�� C*� K^� K� N� �� �<� � � ?Y�� C*� K�� K� N� �           �  �  � ) � - � H �       = o    )   � �  V   	 � H s 
 <      �     `� �� � YK*� �L+� !� � ?Y�� C*� K�� K� N� � /+� �� !� � ?Y�� C*� K�� K� N� � 
� +� �       .    �  �  �  �  � 0 � 3 � : � U � X � _ �       T o     O �   V    � 3 s s$ 
 [ Q     V     �K�� �K*� ����*�           �  � 	 �  �        o    V    �  s 
       &      �� ��           �        �    �