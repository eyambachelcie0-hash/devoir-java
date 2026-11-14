package org.example;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        // Déclaration du Scanner pour la saisie au clavier
        Scanner scanner = new Scanner(System.in);

        // Déclaration des variables selon la convention du document
        String firstName = "";
        String lastName = "";
        String matricule = "";
        int age = 0;
        int filiereChoice = 0;
        String filiere = "";

        double grade1 = 0;
        double grade2 = 0;
        double grade3 = 0;
        double grade4 = 0;
        double total = 0;
        double average = 0;
        double percentage = 0;

        double annualFees = 0;
        double amountPaid = 0;
        double remainingBalance = 0;

        int choice = 0;

        // Indicateurs pour vérifier si les sections ont été remplies
        boolean isStudentRegistered = false;
        boolean areNotesEntered = false;
        boolean isFinancialEntered = false;

        // Boucle do-while pour répéter le menu principal jusqu'à ce que l'utilisateur choisisse 0
        do {
            // Affichage du menu principal
            System.out.println("==GESTION ACADEMIQUE====");
            System.out.println("1. Enregistrer / modifier les informations");
            System.out.println("2. Saisir les quatre notes");
            System.out.println("3. Calculer la moyenne");
            System.out.println("4. Vérifier l'admission et la mention");
            System.out.println("5. Afficher la filière");
            System.out.println("6. Gérer les frais de scolarité");
            System.out.println("7. Afficher le rapport complet");
            System.out.println("0. Quitter");
            System.out.println("====================");
            System.out.print("Votre choix : ");

            // Saisie du choix du menu
            choice = scanner.nextInt();
            scanner.nextLine(); // Consommer la ligne restante

            // Structure switch pour gérer les options du menu
            switch (choice) {
                case 1:
                    // Fonctionnalité 1 : Enregistrer ou modifier les informations de l'étudiant
                    System.out.print("Entrez le prénom : ");
                    firstName = scanner.nextLine();

                    System.out.print("Entrez le nom : ");
                    lastName = scanner.nextLine();

                    System.out.print("Entrez le matricule : ");
                    matricule = scanner.nextLine();

                    // Saisie et validation de l'âge avec if, else if et else
                    System.out.print("Entrez l'âge : ");
                    age = scanner.nextInt();

                    if (age < 0) {
                        System.out.println("Valeur invalide");
                    } else if (age < 17) {
                        System.out.println("Âge non accepté");
                    } else if (age >= 17 && age <= 25) {
                        System.out.println("Âge accepté");
                    } else {
                        System.out.println("Validation administrative nécessaire");
                    }

                    // Affichage du menu des filières
                    System.out.println("====== CHOIX DE LA FILIERE ======");
                    System.out.println("1. Informatique");
                    System.out.println("2. Réseaux et télécommunications");
                    System.out.println("3. Gestion");
                    System.out.println("4. Comptabilité");
                    System.out.print("Votre choix : ");
                    filiereChoice = scanner.nextInt();
                    scanner.nextLine(); // Consommer la ligne

                    // Association du numéro sélectionné au nom de la filière
                    switch (filiereChoice) {
                        case 1:
                            filiere = "Informatique";
                            isStudentRegistered = true;
                            break;
                        case 2:
                            filiere = "Réseaux et télécommunications";
                            isStudentRegistered = true;
                            break;
                        case 3:
                            filiere = "Gestion";
                            isStudentRegistered = true;
                            break;
                        case 4:
                            filiere = "Comptabilité";
                            isStudentRegistered = true;
                            break;
                        default:
                            System.out.println("Filière invalide. Veuillez recommencer.");
                            filiere = "Invalide";
                            isStudentRegistered = false;
                            break;
                    }
                    break;

                case 2:
                    // Fonctionnalité 2 : Saisir les quatre notes avec validation
                    System.out.println("========== SAISIE DES NOTES ==========");

                    // Saisie et validation de la première note
                    do {
                        System.out.print("Entrez la première note : ");
                        grade1 = scanner.nextDouble();
                        if (grade1 < 0 || grade1 > 20) {
                            System.out.println("Note refusée. La note doit être comprise entre 0 et 20.");
                        }
                    } while (grade1 < 0 || grade1 > 20);

                    // Saisie et validation de la deuxième note
                    do {
                        System.out.print("Entrez la deuxième note : ");
                        grade2 = scanner.nextDouble();
                        if (grade2 < 0 || grade2 > 20) {
                            System.out.println("Note refusée. La note doit être comprise entre 0 et 20.");
                        }
                    } while (grade2 < 0 || grade2 > 20);

                    // Saisie et validation de la troisième note
                    do {
                        System.out.print("Entrez la troisième note : ");
                        grade3 = scanner.nextDouble();
                        if (grade3 < 0 || grade3 > 20) {
                            System.out.println("Note refusée. La note doit être comprise entre 0 et 20.");
                        }
                    } while (grade3 < 0 || grade3 > 20);

                    // Saisie et validation de la quatrième note
                    do {
                        System.out.print("Entrez la quatrième note : ");
                        grade4 = scanner.nextDouble();
                        if (grade4 < 0 || grade4 > 20) {
                            System.out.println("Note refusée. La note doit être comprise entre 0 et 20.");
                        }
                    } while (grade4 < 0 || grade4 > 20);

                    areNotesEntered = true;
                    scanner.nextLine(); // Consommer la ligne
                    break;

                case 3:
                    // Fonctionnalité 3 : Calculer les résultats
                    if (!areNotesEntered) {
                        System.out.println("Veuillez d'abord saisir les quatre notes (Option 2).");
                    } else {
                        // Additionner les quatre notes
                        total = grade1 + grade2 + grade3 + grade4;
                        // Diviser le total par quatre
                        average = total / 4;
                        // Calculer le pourcentage par rapport à une note maximale de 20
                        percentage = (average / 20) * 100;

                        System.out.println("========== RESULTATS ACADEMIQUES ==========");
                        System.out.println("Total des notes : " + (int)total);
                        System.out.println("Moyenne : " + (int)average);
                        System.out.println("Pourcentage : " + (int)percentage + " %");
                        System.out.println("===========================================");
                    }
                    break;

                case 4:
                    // Fonctionnalité 4 : Vérifier l'admission et la mention
                    if (!areNotesEntered) {
                        System.out.println("Veuillez d'abord saisir les quatre notes (Option 2).");
                    } else {
                        total = grade1 + grade2 + grade3 + grade4;
                        average = total / 4;

                        System.out.println("========== DECISION ACADEMIQUE ==========");
                        System.out.println("Moyenne : " + (int)average + "/20");

                        // Analyse de la moyenne selon le barème exact
                        if (average < 10) {
                            System.out.println("Décision : NON ADMIS");
                            System.out.println("Mention : ÉCHEC");
                        } else if (average >= 10 && average < 12) {
                            System.out.println("Décision : ADMIS");
                            System.out.println("Mention : PASSABLE");
                        } else if (average >= 12 && average < 14) {
                            System.out.println("Décision : ADMIS");
                            System.out.println("Mention : ASSEZ BIEN");
                        } else if (average >= 14 && average < 16) {
                            System.out.println("Décision : ADMIS");
                            System.out.println("Mention : BIEN");
                        } else {
                            System.out.println("Décision : ADMIS");
                            System.out.println("Mention : TRÈS BIEN");
                        }
                        System.out.println("=========================================");
                    }
                    break;

                case 5:
                    // Fonctionnalité 5 : Afficher la filière et les informations de l'étudiant
                    if (!isStudentRegistered) {
                        System.out.println("Il faut d'abord enregistrer l'étudiant.");
                    } else {
                        System.out.println("========== INFORMATIONS ACADEMIQUES ==========");
                        System.out.println("Etudiant : " + firstName + " " + lastName);
                        System.out.println("Matricule : " + matricule);
                        System.out.println("Filiere : " + filiere);
                        System.out.println("==============================================");
                    }
                    break;

                case 6:
                    // Fonctionnalité 6 : Gérer les frais de scolarité
                    boolean validFees = false;
                    do {
                        System.out.print("Entrez le montant annuel des frais de scolarité : ");
                        annualFees = scanner.nextDouble();

                        System.out.print("Entrez le montant déjà payé : ");
                        amountPaid = scanner.nextDouble();

                        if (annualFees < 0 || amountPaid < 0) {
                            System.out.println("Erreur : Les montants ne doivent pas être négatifs.");
                        } else if (amountPaid > annualFees) {
                            System.out.println("Erreur : Le montant payé dépasse les frais annuels. Veuillez recommencer.");
                        } else {
                            validFees = true;
                        }
                    } while (!validFees);

                    // Calcul du solde restant
                    remainingBalance = annualFees - amountPaid;

                    isFinancialEntered = true;

                    System.out.println("========== SUIVI FINANCIER ==========");
                    System.out.println("Frais annuels : " + (int)annualFees + " FCFA");
                    System.out.println("Montant payé : " + (int)amountPaid + " FCFA");
                    System.out.println("Solde restant : " + (int)remainingBalance + " FCFA");

                    if (remainingBalance == 0) {
                        System.out.println("Statut : PAIEMENT COMPLET");
                    } else {
                        System.out.println("Statut : PAIEMENT INCOMPLET");
                    }
                    System.out.println("=====================================");
                    scanner.nextLine(); // Consommer la ligne
                    break;

                case 7:
                    // Fonctionnalité 7 : Afficher le rapport complet
                    System.out.println("==========================================");
                    System.out.println("          RAPPORT DE L'ETUDIANT           ");
                    System.out.println("==========================================");

                    System.out.println("INFORMATIONS PERSONNELLES");
                    if (!isStudentRegistered) {
                        System.out.println("Nom : Non enregistré");
                        System.out.println("Matricule : Non enregistré");
                        System.out.println("Age : Non enregistré");
                        System.out.println("Filiere : Non enregistré");
                    } else {
                        System.out.println("Nom : " + firstName + " " + lastName);
                        System.out.println("Matricule : " + matricule);
                        System.out.println("Age : " + age + " ans");
                        System.out.println("Filiere : " + filiere);
                    }

                    System.out.println("------------------------------------------");
                    System.out.println("RESULTATS ACADEMIQUES");
                    if (!areNotesEntered) {
                        System.out.println("Notes non encore saisies.");
                    } else {
                        total = grade1 + grade2 + grade3 + grade4;
                        average = total / 4;
                        percentage = (average / 20) * 100;

                        System.out.println("Note 1 : " + grade1);
                        System.out.println("Note 2 : " + grade2);
                        System.out.println("Note 3 : " + grade3);
                        System.out.println("Note 4 : " + grade4);
                        System.out.println("Total : " + (int)total);
                        System.out.println("Moyenne : " + (int)average + "/20");
                        System.out.println("Pourcentage : " + (int)percentage + " %");

                        if (average < 10) {
                            System.out.println("Decision : NON ADMIS");
                            System.out.println("Mention : ÉCHEC");
                        } else if (average >= 10 && average < 12) {
                            System.out.println("Decision : ADMIS");
                            System.out.println("Mention : PASSABLE");
                        } else if (average >= 12 && average < 14) {
                            System.out.println("Decision : ADMIS");
                            System.out.println("Mention : ASSEZ BIEN");
                        } else if (average >= 14 && average < 16) {
                            System.out.println("Decision : ADMIS");
                            System.out.println("Mention : BIEN");
                        } else {
                            System.out.println("Decision : ADMIS");
                            System.out.println("Mention : TRÈS BIEN");
                        }
                    }

                    System.out.println("------------------------------------------");
                    System.out.println("SITUATION FINANCIERE");
                    if (!isFinancialEntered) {
                        System.out.println("Informations financières non saisies.");
                    } else {
                        System.out.println("Frais annuels : " + (int)annualFees + " FCFA");
                        System.out.println("Montant payé : " + (int)amountPaid + " FCFA");
                        System.out.println("Solde restant : " + (int)remainingBalance + " FCFA");
                        if (remainingBalance == 0) {
                            System.out.println("Statut : PAIEMENT COMPLET");
                        } else {
                            System.out.println("Statut : PAIEMENT INCOMPLET");
                        }
                    }
                    System.out.println("==========================================");
                    break;

                case 0:
                    // Option 0 : Quitter le programme
                    System.out.println("Arrêt du programme. Au revoir !");
                    break;

                default:
                    // Option inexistante
                    System.out.println("Option invalide, retour au menu");
                    break;
            }

        } while (choice != 0);

        scanner.close();
    }
}