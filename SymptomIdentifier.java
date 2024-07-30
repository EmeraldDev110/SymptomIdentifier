import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SymptomIdentifier {

    // Define a dictionary mapping keywords to symptoms/disorders with weights
    private static final Map<String, String> symptomDictionary = new HashMap<>();

    static {
        symptomDictionary.put("head injury", "Traumatic Brain Injury");
        symptomDictionary.put("concussion", "Traumatic Brain Injury");
        symptomDictionary.put("brain trauma", "Traumatic Brain Injury");
        symptomDictionary.put("cognitive impairment", "Traumatic Brain Injury");
        symptomDictionary.put("neurological damage", "Traumatic Brain Injury");
        symptomDictionary.put("alcohol dependency", "Alcoholism");
        symptomDictionary.put("excessive drinking", "Alcoholism");
        symptomDictionary.put("alcohol abuse", "Alcoholism");
        symptomDictionary.put("alcohol addiction", "Alcoholism");
        symptomDictionary.put("binge drinking", "Alcoholism");
        symptomDictionary.put("substance abuse", "Drug Abuse");
        symptomDictionary.put("drug addiction", "Drug Abuse");
        symptomDictionary.put("narcotic use", "Drug Abuse");
        symptomDictionary.put("illicit drugs", "Drug Abuse");
        symptomDictionary.put("dependency", "Drug Abuse");
        symptomDictionary.put("compulsive gambling", "Gambling");
        symptomDictionary.put("betting addiction", "Gambling");
        symptomDictionary.put("gambling problem", "Gambling");
        symptomDictionary.put("gaming disorder", "Gambling");
        symptomDictionary.put("wagering issues", "Gambling");
        symptomDictionary.put("attention deficit", "ADHD");
        symptomDictionary.put("hyperactivity", "ADHD");
        symptomDictionary.put("impulsivity", "ADHD");
        symptomDictionary.put("inattention", "ADHD");
        symptomDictionary.put("distractibility", "ADHD");
        symptomDictionary.put("irritability", "Anger");
        symptomDictionary.put("rage", "Anger");
        symptomDictionary.put("temper issues", "Anger");
        symptomDictionary.put("aggression", "Anger");
        symptomDictionary.put("hostility", "Anger");
        symptomDictionary.put("anxious", "Anxiety");
        symptomDictionary.put("nervousness", "Anxiety");
        symptomDictionary.put("worry", "Anxiety");
        symptomDictionary.put("apprehension", "Anxiety");
        symptomDictionary.put("unease", "Anxiety");
        symptomDictionary.put("panic attacks", "Panic");
        symptomDictionary.put("intense fear", "Panic");
        symptomDictionary.put("sudden anxiety", "Panic");
        symptomDictionary.put("terror", "Panic");
        symptomDictionary.put("palpitations", "Panic");
        symptomDictionary.put("irrational fear", "Phobia");
        symptomDictionary.put("aversion", "Phobia");
        symptomDictionary.put("specific phobia", "Phobia");
        symptomDictionary.put("dread", "Phobia");
        symptomDictionary.put("avoidance", "Phobia");
        symptomDictionary.put("trauma response", "PTSD");
        symptomDictionary.put("flashbacks", "PTSD");
        symptomDictionary.put("hypervigilance", "PTSD");
        symptomDictionary.put("nightmares", "PTSD");
        symptomDictionary.put("intrusive thoughts", "PTSD");
        symptomDictionary.put("social fear", "Social Anxiety");
        symptomDictionary.put("social discomfort", "Social Anxiety");
        symptomDictionary.put("public speaking anxiety", "Social Anxiety");
        symptomDictionary.put("shyness", "Social Anxiety");
        symptomDictionary.put("fear of judgment", "Social Anxiety");
        symptomDictionary.put("social challenges", "Asperger's Syndrome");
        symptomDictionary.put("repetitive behaviors", "Asperger's Syndrome");
        symptomDictionary.put("narrow interests", "Asperger's Syndrome");
        symptomDictionary.put("communication difficulties", "Asperger's Syndrome");
        symptomDictionary.put("sensory issues", "Asperger's Syndrome");
        symptomDictionary.put("difficulty bonding", "Attachment Disorder (RAD)");
        symptomDictionary.put("emotional withdrawal", "Attachment Disorder (RAD)");
        symptomDictionary.put("lack of trust", "Attachment Disorder (RAD)");
        symptomDictionary.put("relationship issues", "Attachment Disorder (RAD)");
        symptomDictionary.put("attachment issues", "Attachment Disorder (RAD)");
        symptomDictionary.put("dependency issues", "Codependent");
        symptomDictionary.put("enmeshment", "Codependent");
        symptomDictionary.put("relationship dysfunction", "Codependent");
        symptomDictionary.put("over-reliance", "Codependent");
        symptomDictionary.put("lack of boundaries", "Codependent");
        symptomDictionary.put("sadness", "Depression");
        symptomDictionary.put("hopelessness", "Depression");
        symptomDictionary.put("lack of interest", "Depression");
        symptomDictionary.put("fatigue", "Depression");
        symptomDictionary.put("low energy", "Depression");
        symptomDictionary.put("detachment", "Dissociative Disorders");
        symptomDictionary.put("identity confusion", "Dissociative Disorders");
        symptomDictionary.put("memory gaps", "Dissociative Disorders");
        symptomDictionary.put("dissociation", "Dissociative Disorders");
        symptomDictionary.put("altered perception", "Dissociative Disorders");
        symptomDictionary.put("anorexia", "Eating Disorders");
        symptomDictionary.put("bulimia", "Eating Disorders");
        symptomDictionary.put("binge eating", "Eating Disorders");
        symptomDictionary.put("food restriction", "Eating Disorders");
        symptomDictionary.put("eating anxiety", "Eating Disorders");
        symptomDictionary.put("mood swings", "Emotional Dysregulation");
        symptomDictionary.put("intense emotions", "Emotional Dysregulation");
        symptomDictionary.put("difficulty controlling emotions", "Emotional Dysregulation");
        symptomDictionary.put("emotional instability", "Emotional Dysregulation");
        symptomDictionary.put("rapid mood changes", "Emotional Dysregulation");
        symptomDictionary.put("lack of empathy", "Poor Empathy with Poor Eye Contact");
        symptomDictionary.put("social detachment", "Poor Empathy with Poor Eye Contact");
        symptomDictionary.put("avoidance of eye contact", "Poor Empathy with Poor Eye Contact");
        symptomDictionary.put("emotional distance", "Poor Empathy with Poor Eye Contact");
        symptomDictionary.put("interpersonal difficulties", "Poor Empathy with Poor Eye Contact");
        symptomDictionary.put("excessive collecting", "Hoarding");
        symptomDictionary.put("inability to discard", "Hoarding");
        symptomDictionary.put("clutter", "Hoarding");
        symptomDictionary.put("accumulation", "Hoarding");
        symptomDictionary.put("compulsive saving", "Hoarding");
        symptomDictionary.put("impulsivity", "Poor Impulse Control or Weak Inhibition");
        symptomDictionary.put("lack of restraint", "Poor Impulse Control or Weak Inhibition");
        symptomDictionary.put("poor decision making", "Poor Impulse Control or Weak Inhibition");
        symptomDictionary.put("reckless behavior", "Poor Impulse Control or Weak Inhibition");
        symptomDictionary.put("spontaneous actions", "Poor Impulse Control or Weak Inhibition");
        symptomDictionary.put("reading difficulty", "Dyslexia");
        symptomDictionary.put("letter reversal", "Dyslexia");
        symptomDictionary.put("slow reading", "Dyslexia");
        symptomDictionary.put("word recognition issues", "Dyslexia");
        symptomDictionary.put("spelling problems", "Dyslexia");
        symptomDictionary.put("math difficulty", "Dyscalculia or Acalculia");
        symptomDictionary.put("number confusion", "Dyscalculia or Acalculia");
        symptomDictionary.put("calculation issues", "Dyscalculia or Acalculia");
        symptomDictionary.put("arithmetic struggles", "Dyscalculia or Acalculia");
        symptomDictionary.put("numerical processing issues", "Dyscalculia or Acalculia");
        symptomDictionary.put("reading struggles", "Poor Reading Comprehension");
        symptomDictionary.put("understanding text", "Poor Reading Comprehension");
        symptomDictionary.put("difficulty grasping meaning", "Poor Reading Comprehension");
        symptomDictionary.put("text comprehension issues", "Poor Reading Comprehension");
        symptomDictionary.put("poor retention", "Poor Reading Comprehension");
        symptomDictionary.put("writing challenges", "Poor Writing Skills");
        symptomDictionary.put("difficulty expressing in writing", "Poor Writing Skills");
        symptomDictionary.put("poor grammar", "Poor Writing Skills");
        symptomDictionary.put("spelling issues", "Poor Writing Skills");
        symptomDictionary.put("writing fluency problems", "Poor Writing Skills");
        symptomDictionary.put("sensory overload", "Sensory Processing Disorder");
        symptomDictionary.put("sensory sensitivity", "Sensory Processing Disorder");
        symptomDictionary.put("difficulty processing stimuli", "Sensory Processing Disorder");
        symptomDictionary.put("sensory integration issues", "Sensory Processing Disorder");
        symptomDictionary.put("hypersensitivity", "Sensory Processing Disorder");
        symptomDictionary.put("trouble following steps", "Poor Sequential Processing");
        symptomDictionary.put("sequence confusion", "Poor Sequential Processing");
        symptomDictionary.put("order of operations issues", "Poor Sequential Processing");
        symptomDictionary.put("task sequencing difficulties", "Poor Sequential Processing");
        symptomDictionary.put("step-by-step processing issues", "Poor Sequential Processing");
        symptomDictionary.put("ignoring one side", "Spatial Neglect");
        symptomDictionary.put("spatial unawareness", "Spatial Neglect");
        symptomDictionary.put("neglect syndrome", "Spatial Neglect");
        symptomDictionary.put("hemispatial neglect", "Spatial Neglect");
        symptomDictionary.put("spatial inattention", "Spatial Neglect");
        symptomDictionary.put("difficulty understanding speech", "Poor Auditory Processing or Aphasia");
        symptomDictionary.put("hearing issues", "Poor Auditory Processing or Aphasia");
        symptomDictionary.put("language comprehension problems", "Poor Auditory Processing or Aphasia");
        symptomDictionary.put("auditory perception issues", "Poor Auditory Processing or Aphasia");
        symptomDictionary.put("speech processing difficulties", "Poor Auditory Processing or Aphasia");
        symptomDictionary.put("visual perception issues", "Poor Visual Processing");
        symptomDictionary.put("trouble interpreting visual information", "Poor Visual Processing");
        symptomDictionary.put("visual difficulties", "Poor Visual Processing");
        symptomDictionary.put("visual processing disorder", "Poor Visual Processing");
        symptomDictionary.put("poor visual discrimination", "Poor Visual Processing");
        symptomDictionary.put("memory loss", "Dementia");
        symptomDictionary.put("cognitive decline", "Dementia");
        symptomDictionary.put("confusion", "Dementia");
        symptomDictionary.put("disorientation", "Dementia");
        symptomDictionary.put("impaired thinking", "Dementia");
        symptomDictionary.put("trouble remembering events", "Poor Episodic Memory Recall");
        symptomDictionary.put("memory gaps", "Poor Episodic Memory Recall");
        symptomDictionary.put("episodic memory issues", "Poor Episodic Memory Recall");
        symptomDictionary.put("recall difficulties", "Poor Episodic Memory Recall");
        symptomDictionary.put("event forgetfulness", "Poor Episodic Memory Recall");
        symptomDictionary.put("forgetfulness", "General Forgetfulness or Age Related Cognitive Decline");
        symptomDictionary.put("age-related memory loss", "General Forgetfulness or Age Related Cognitive Decline");
        symptomDictionary.put("senior moments", "General Forgetfulness or Age Related Cognitive Decline");
        symptomDictionary.put("cognitive decline", "General Forgetfulness or Age Related Cognitive Decline");
        symptomDictionary.put("memory lapses", "General Forgetfulness or Age Related Cognitive Decline");
        symptomDictionary.put("getting lost", "Poor Navigational Skills");
        symptomDictionary.put("difficulty with directions", "Poor Navigational Skills");
        symptomDictionary.put("spatial navigation issues", "Poor Navigational Skills");
        symptomDictionary.put("wayfinding problems", "Poor Navigational Skills");
        symptomDictionary.put("directional confusion", "Poor Navigational Skills");
        symptomDictionary.put("memory retrieval issues", "Poor Memory Retrieval or Poor Working Memory");
        symptomDictionary.put("working memory problems", "Poor Memory Retrieval or Poor Working Memory");
        symptomDictionary.put("forgetfulness", "Poor Memory Retrieval or Poor Working Memory");
        symptomDictionary.put("recall difficulties", "Poor Memory Retrieval or Poor Working Memory");
        symptomDictionary.put("short-term memory issues", "Poor Memory Retrieval or Poor Working Memory");
        symptomDictionary.put("clumsiness", "Weak Fine Motor Skills");
        symptomDictionary.put("trouble with small movements", "Weak Fine Motor Skills");
        symptomDictionary.put("fine motor challenges", "Weak Fine Motor Skills");
        symptomDictionary.put("dexterity issues", "Weak Fine Motor Skills");
        symptomDictionary.put("hand coordination problems", "Weak Fine Motor Skills");
        symptomDictionary.put("difficulty with large movements", "Weak Gross Motor Skills");
        symptomDictionary.put("poor coordination", "Weak Gross Motor Skills");
        symptomDictionary.put("gross motor challenges", "Weak Gross Motor Skills");
        symptomDictionary.put("motor skill deficits", "Weak Gross Motor Skills");
        symptomDictionary.put("physical awkwardness", "Weak Gross Motor Skills");
        symptomDictionary.put("obsessive thoughts", "OCD");
        symptomDictionary.put("compulsive behaviors", "OCD");
        symptomDictionary.put("ritualistic actions", "OCD");
        symptomDictionary.put("intrusive thoughts", "OCD");
        symptomDictionary.put("repetitive behaviors", "OCD");
        symptomDictionary.put("tics", "Tourette's");
        symptomDictionary.put("involuntary movements", "Tourette's");
        symptomDictionary.put("vocal outbursts", "Tourette's");
        symptomDictionary.put("motor tics", "Tourette's");
        symptomDictionary.put("vocal tics", "Tourette's");
        symptomDictionary.put("hair pulling", "Trichotillomania");
        symptomDictionary.put("compulsive hair removal", "Trichotillomania");
        symptomDictionary.put("hair loss", "Trichotillomania");
        symptomDictionary.put("pulling urges", "Trichotillomania");
        symptomDictionary.put("hair plucking", "Trichotillomania");
        symptomDictionary.put("persistent pain", "Chronic Pain");
        symptomDictionary.put("long-term pain", "Chronic Pain");
        symptomDictionary.put("pain management issues", "Chronic Pain");
        symptomDictionary.put("ongoing discomfort", "Chronic Pain");
        symptomDictionary.put("chronic discomfort", "Chronic Pain");
        symptomDictionary.put("widespread pain", "Fibromyalgia");
        symptomDictionary.put("chronic fatigue", "Fibromyalgia");
        symptomDictionary.put("tender points", "Fibromyalgia");
        symptomDictionary.put("muscle pain", "Fibromyalgia");
        symptomDictionary.put("fibromyalgia symptoms", "Fibromyalgia");
        symptomDictionary.put("persistent tiredness", "Chronic Fatigue");
        symptomDictionary.put("exhaustion", "Chronic Fatigue");
        symptomDictionary.put("lack of energy", "Chronic Fatigue");
        symptomDictionary.put("chronic fatigue syndrome", "Chronic Fatigue");
        symptomDictionary.put("prolonged fatigue", "Chronic Fatigue");
        symptomDictionary.put("psychosis", "Schizophrenia with Hallucinations and Delusions");
        symptomDictionary.put("hallucinations", "Schizophrenia with Hallucinations and Delusions");
        symptomDictionary.put("delusions", "Schizophrenia with Hallucinations and Delusions");
        symptomDictionary.put("thought disorder", "Schizophrenia with Hallucinations and Delusions");
        symptomDictionary.put("paranoid schizophrenia", "Schizophrenia with Hallucinations and Delusions");
        symptomDictionary.put("paranoid thoughts", "Schizophrenia with Paranoia");
        symptomDictionary.put("distrust", "Schizophrenia with Paranoia");
        symptomDictionary.put("schizophrenia symptoms", "Schizophrenia with Paranoia");
        symptomDictionary.put("suspicion", "Schizophrenia with Paranoia");
        symptomDictionary.put("paranoid delusions", "Schizophrenia with Paranoia");
        symptomDictionary.put("low self-esteem", "Poor Sense of Self or Weak Self-Esteem");
        symptomDictionary.put("identity issues", "Poor Sense of Self or Weak Self-Esteem");
        symptomDictionary.put("self-doubt", "Poor Sense of Self or Weak Self-Esteem");
        symptomDictionary.put("poor self-image", "Poor Sense of Self or Weak Self-Esteem");
        symptomDictionary.put("lack of confidence", "Poor Sense of Self or Weak Self-Esteem");
        symptomDictionary.put("unstable relationships", "Personality Disorder");
        symptomDictionary.put("personality changes", "Personality Disorder");
        symptomDictionary.put("behavioral issues", "Personality Disorder");
        symptomDictionary.put("identity disturbances", "Personality Disorder");
        symptomDictionary.put("emotional instability", "Personality Disorder");
        symptomDictionary.put("sleep problems", "Poor Sleep or Insomnia");
        symptomDictionary.put("trouble sleeping", "Poor Sleep or Insomnia");
        symptomDictionary.put("insomnia", "Poor Sleep or Insomnia");
        symptomDictionary.put("sleep disturbances", "Poor Sleep or Insomnia");
        symptomDictionary.put("difficulty falling asleep", "Poor Sleep or Insomnia");
        symptomDictionary.put("social awkwardness", "Poor Social Skills");
        symptomDictionary.put("difficulty interacting", "Poor Social Skills");
        symptomDictionary.put("poor communication", "Poor Social Skills");
        symptomDictionary.put("social challenges", "Poor Social Skills");
        symptomDictionary.put("interpersonal difficulties", "Poor Social Skills");
        symptomDictionary.put("speech interruptions", "Stuttering");
        symptomDictionary.put("fluency issues", "Stuttering");
        symptomDictionary.put("speech disfluency", "Stuttering");
        symptomDictionary.put("stammering", "Stuttering");
        symptomDictionary.put("verbal blocks", "Stuttering");
        symptomDictionary.put("shaking", "Tremors or Parkinson's");
        symptomDictionary.put("tremors", "Tremors or Parkinson's");
        symptomDictionary.put("Parkinson's disease symptoms", "Tremors or Parkinson's");
        symptomDictionary.put("involuntary movements", "Tremors or Parkinson's");
        symptomDictionary.put("motor symptoms", "Tremors or Parkinson's");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Describe your client's symptoms: ");
        String description = scanner.nextLine().toLowerCase();

        // Initialize a map to store the scores for each disorder
        Map<String, Integer> disorderScores = new HashMap<>();

        // Iterate over each keyword in the symptom dictionary
        for (Map.Entry<String, String> entry : symptomDictionary.entrySet()) {
            String keyword = entry.getKey();
            String disorder = entry.getValue();
            if (description.contains(keyword)) {
                disorderScores.put(disorder, disorderScores.getOrDefault(disorder, 0) + 1);
            }
        }

        // Find the disorder with the highest score
        String likelyDisorder = null;
        int maxScore = 0;
        for (Map.Entry<String, Integer> entry : disorderScores.entrySet()) {
            if (entry.getValue() > maxScore) {
                maxScore = entry.getValue();
                likelyDisorder = entry.getKey();
            }
        }

        // Output the result
        if (likelyDisorder != null) {
            System.out.println("The most likely disorder is: " + likelyDisorder);
        } else {
            System.out.println("No matching disorder found.");
        }

        scanner.close();
    }
}
