����   4 d  GestioneRubriche  java/lang/Object rubriche Ljava/util/HashMap; 	Signature 0Ljava/util/HashMap<Ljava/lang/String;LRubrica;>; <clinit> ()V Code  java/util/HashMap
    
 <init>	     LineNumberTable LocalVariableTable
   this LGestioneRubriche; creaRubrica (Ljava/lang/String;I)I  Rubrica
     (Ljava/lang/String;I)V
    ! " get &(Ljava/lang/Object;)Ljava/lang/Object;
  $ % & put 8(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; nome Ljava/lang/String; maxDim I nuovaRubrica 	LRubrica; StackMapTable cancellaRubrica (Ljava/lang/String;)I
  1 2 " remove aggiungiInRubrica '(Ljava/lang/String;Ljava/lang/String;)I 
Exceptions 7 FormatException 9 ,
 ; = < java/lang/String > ? split '(Ljava/lang/String;)[Ljava/lang/String;
  A B C aggiungi 9(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I newEl contatto [Ljava/lang/String; cercaInRubricaPerNome ;(Ljava/lang/String;Ljava/lang/String;)Ljava/util/ArrayList; G(Ljava/lang/String;Ljava/lang/String;)Ljava/util/ArrayList<LContatto;>;
  K L M cercaPerNome )(Ljava/lang/String;)Ljava/util/ArrayList; el cercaInRubricaPerEMail
  Q R M cercaPerEMail cancellaInRubricaPerNome '(Ljava/lang/String;Ljava/lang/String;)Z
  V W X eliminaPerNome (Ljava/lang/String;)V cancellaInRubricaPerEMail
  [ \ X eliminaPerEMail toString &(Ljava/lang/String;)Ljava/lang/String;
  ` ] a ()Ljava/lang/String; 
SourceFile GestioneRubriche.java !      
         
  	 
     +      � Y� � �                    
     /     *� �                        	       }     !� Y*� M� *� � �� *,� #W�           	 
 
               ! ' (     ! ) *  
  + ,  -    �   	 . /     I     � *� 0� ��            
            ' (   -     	 3 4  5     6    }     *� *� � !+8� :M� *� � ,2,2,2� @��            
    (          * ' (     * D (    E F  -    ( 	 G H      I    `     � *� � � *� � +� J��           ! 
 "  $         ' (      N (  -     	 O H      I    `     � *� � � *� � +� P��           ( 
 )  +         ' (      N (  -     	 S T     e     � *� � � *� � +� U��           / 
 0  1  3         ' (      N (  -     	 Y T     e     � *� � � *� � +� Z��           7 
 8  9  ;         ' (      N (  -     	 ] ^     U     � *� � � *� � � _��           ? 
 @  B         ' (   -      b    c