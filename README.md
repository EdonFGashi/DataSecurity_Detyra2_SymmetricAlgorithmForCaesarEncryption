# DataSecurity_Detyra2_SymmetricAlgorithmForCaesarEncryption
Universiteti i Prishtinës "Hasan Prishtina"
Fakulteti i Inxhinierisë Elektrike dhe Kompjuterike / Departamenti i Inxhinierisë Softuerike dhe Kompjuterike
Titulli i projektit: Implementimi i SymmetricAlgorithm për enkriptim dhe dekriptim të kodit të Cezarit. Bajtat që nuk janë shkronja A-Z ose a-z të mos ndryshohen.
Emrat e studentëve të grupit: Edon Gashi, Dreni Nimanaj, Eden Dobra dhe Elion Mehaj
Emri i profesorit: Prof. Dr. Blerim Rexha

Përshkrimi i projektit: ideja e këtij projekti është që të implementohet një program
i cili bën të mundur enkriptimin e fjalëve përmes algoritmit të kodt të Cezarit, si 
algoritëm simetrik. Përveç kësaj kodi mundëson edhe dekriptimin. Programi i 
implementuar nuk bën komprementim të informacioneve me brute force mirëpo duke e ditur
paraprakisht çelësin, kryhet procesi i enkriptimit apo dekriptimit. Programi është i aftë 
që të mos pranojë karaktere të panjohura si çelës përveç numrave si dhe karakteret që 
vendosen si plain text e që nuk janë shkronja nuk hyjnë në procesin e enkriptimit apo 
dekriptimit, përveç shkronjave të alfabetit anglez (nga a deri në z dhe nga A deri në Z).
Programi përmban edhe një GUI që mundëson interaktivitet të lehtë. Programi është shkruar 
në gjuhën programuese Java dhe GUI është bërë me JavaFX. Për tu përdorur ky program nuk 
nevojtet softuer special, mjafton të keni editor që e kompajlon këtë gjuhë programuese.

Rezultatet e projektit: ky program mund të shfrytëzohet për enkriptim dhe dekriptim të një 
informaiconi me kodin e Cezarit
Për enkriptim e merr si hyrje një plain text dhe një çelës të enkriptimit (që është numër 
i plotë) dhe përmes butonit "Encrypt" e shfaq si rezultat një cipher text të enkriptuar.
Për dekriptim e merr si hyrje një cipher text dhe çelësin me të cilin është enkriptuar ai 
tekst dhe përmes butonit "Decrypt" e shfaq si rezultat tekstin e dekriptuar.
Butonat clear përdoren për të pastruar fushat me tekst.