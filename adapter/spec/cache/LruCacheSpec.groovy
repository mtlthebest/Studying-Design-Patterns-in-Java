package cache

import spock.lang.Specification

class LruCacheSpec extends Specification {

	def max = 3
	def subject = new LruCache<String, String>(max)	

	def "�ő�����L���b�V������"(){
		when:
		subject.cache("key1", "value1");
		subject.cache("key2", "value2");
		subject.cache("key3", "value3");
		then:
		subject.load("key1") == "value1"
	}
	
	def "�ő���𒴂��ăL���b�V������"(){
		when:
		subject.cache("key1", "value1");
		subject.cache("key2", "value2");
		subject.cache("key3", "value3");
		subject.cache("key4", "value4");
		then:
		subject.load("key1") == null;
	}
}
