package hash;

import java.util.*;
import java.util.stream.Collectors;

/**
 *
 ����һ���ַ������飬����ĸ��λ�������һ����ĸ��λ��ָ��ĸ��ͬ�������в�ͬ���ַ�����

 ʾ��:

 ����: ["eat", "tea", "tan", "ate", "nat", "bat"]
 ���:
 [
 ["ate","eat","tea"],
 ["nat","tan"],
 ["bat"]
 ]
 ˵����

 ���������ΪСд��ĸ��
 �����Ǵ������˳��
 * @author cwp
 */
public class GroupAnagrams_49 {
    public static void main(String[] args) {

        String[] strings = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = groupAnagrams(strings);
        System.out.println(lists);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<Integer, List<String>> map = new HashMap<Integer, List<String>>();
        for (String str : strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String x = String.valueOf(chars);
            int i = x.hashCode();
            if (map.containsKey(i)){
                map.get(i).add(str);
            }else {
                ArrayList<String> list = new ArrayList<String>();
                list.add(str);
                map.put(i, list);
            }
        };
        Collection<List<String>> values = map.values();
        return new ArrayList<List<String>>(values);
    }

    public List<List<String>> groupAnagrams2(String[] strs) {

        // �����˹�ϣ�����Ļ���֪ʶ��ֻҪ 26 ������
        // ��Сд��ĸACSII �� - 97 ���Ժ�������Ķ�Ӧ������������Ԫ��˳������ν
        // key ���±꣬value ������ֵ
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29,
                31, 37, 41, 43, 47, 53, 59, 61, 67, 71,
                73, 79, 83, 89, 97, 101};

        // key ���ַ����Զ�������µĹ�ϣֵ
        Map<Integer, List<String>> hashMap = new HashMap<>();
        for (String s : strs) {
            int hashValue = 1;

            char[] charArray = s.toCharArray();
            for (char c : charArray) {
                hashValue *= primes[c - 'a'];
            }

            // �ѵ�����ӵ���ϣֵ��ͬ�ķ���
            if (hashMap.containsKey(hashValue)) {
                List<String> curList = hashMap.get(hashValue);
                curList.add(s);
            } else {
                List<String> newList = new ArrayList<>();
                newList.add(s);

                hashMap.put(hashValue, newList);
            }
        }
        return new ArrayList<>(hashMap.values());
    }

}
