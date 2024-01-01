package com.example.hackscore;

public class BackEnd {
    private static String [] questionList = {
            "How many different passwords do you use across your online accounts?",
            "Do you use two-factor authentication (2FA) for your important accounts?",
            "How do you manage software and operating system updates on your devices?",
            "How do you handle unsolicited emails or messages asking for personal information?",
            "How do you manage your Wi-Fi network security?",
            "How do you handle software or app permissions on your devices?",
            "How often do you back up your important data?",
            "How cautious are you when receiving messages from unknown contacts on social media?",
            "How often do you review privacy settings on your online accounts?",
            "Do you have a PIN or password set on your mobile device?",
            "What is your response plan if you suspect a security breach on your computer or accounts?",
            "How often do you run antivirus scans on your computer?",
            "How do you handle personal information shared online, such as your address and phone number?",
            "Do you use biometric authentication (fingerprint, face recognition) on your devices?",
            "Do you secure physical access to your devices (laptop, smartphone)?",
            "How often do you stay updated on cybersecurity best practices?",
            "How do you verify the authenticity of websites before entering sensitive information?",
            "How often do you clear your browser cache and cookies for privacy?",
            "Do you illegally stream entertainment?",
            "How do you protect your personal information when using public Wi-Fi networks at coffee shops or airports?",
            "Do you review and update the security configurations of your cloud storage accounts?",
            "In what ways do you verify the authenticity of prompted software updates?",
            "What procedures do you take when you dispose of electronic devices that previously stored information",
            "Do you sign in on other people’s devices?",
            "Who do you let access your home network?"
    };
    private static String [] option1List = {
            "One password",
            "Never",
            "I don't update, or only when forced to",
            "I open or respond to them",
            "I do not have Wi-Fi security",
            "I grant all permissions by default",
            "I never back up my data",
            "I accept all friend/follow requests",
            "Never",
            "No",
            "I don't have a response plan",
            "Never",
            "I share openly",
            "No",
            "Never",
            "I don't",
            "I don't",
            "Never",
            "Often",
            "I don't",
            "No",
            "I don't",
            "I just throw it out",
            "Often",
            "Anyone"
    };
    private static String [] option2List = {
            "One password with slight variations",
            "Sometimes",
            "I update it at some point",
            "I just check it out",
            "I just set up the router and use it",
            "I allow by default but disallow certain features",
            "Sometimes",
            "I will see if we have mutual friends",
            "Sometimes",
            "Yes, a 4 digit pin",
            "I would ask someone what to do",
            "Sometimes",
            "I try not to share anything that could be sensitive information",
            "Sometimes",
            "Just a password",
            "Sometimes",
            "I look at the URL",
            "Sometimes",
            "Sometimes",
            "I won't send any sensitive information over the internet",
            "Sometimes",
            "I would see if it looks authentic",
            "I sign out out of all accounts",
            "Sometimes",
            "Friends"
    };
    private static String [] option3List = {
            "Many different passwords",
            "Most of the time",
            "I manually update when I receive notice",
            "I ignore it",
            "I set up the router and change the credentials",
            "I allow by default but disallow all unnecessary features",
            "Most of the time",
            "I will see if it looks like I know them",
            "Most of the time",
            "Yes, a 6 digit pin",
            "I would run an antivirus",
            "Often",
            "I share no potentially sensitive information",
            "Usually",
            "I block data ports",
            "Most of the time",
            "I look through the website",
            "Often",
            "Almost never",
            "I would use a VPN",
            "Often",
            "I would read the full details of the update",
            "I'll clear the memory of the storage",
            "Almost never",
            "Close friends or family"
    };
    private static String [] option4List = {
            "A unique password for each",
            "Always",
            "I have automatically scheduled updates",
            "I block and report it",
            "I change the credentials and set up network encryption (WPA2)",
            "I disallow all by default",
            "I have automatic backups scheduled",
            "I will ask the person requesting a message to ensure I know them",
            "I review all settings when privacy terms are created or updated",
            "Yes, an alphanumeric text password",
            "I would go offline and quarantine the malware",
            "I have automatic antivirus scans scheduled",
            "I share no personal information",
            "Always",
            "I do not let my device outside of my possession",
            "Always",
            "I will check the website's digital certificate",
            "I have automatic cache and cookie clearing scheduled",
            "Never",
            "I would not enter any public network",
            "I would review when security configurations are made or updated",
            "I would check the the validity of the update on the company's website",
            "I'll clear the memory and overwrite the hard drive with 0's and 1's",
            "Never",
            "Only trusted or immediate family"
    };

    //GETTERS
    public static String getQuestion(int index) {
        return questionList[index];
    }
    public static String getOption1(int index) {
        return option1List[index];
    }
    public static String getOption2(int index) {
        return option2List[index];
    }
    public static String getOption3(int index) {
        return option3List[index];
    }
    public static String getOption4(int index) {
        return option4List[index];
    }
}