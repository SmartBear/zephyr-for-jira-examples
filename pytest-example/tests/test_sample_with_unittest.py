import pytest
import unittest

class TestStringMethods(unittest.TestCase):

    def test_upper_DEV_123(self):
        self.assertEqual('foo'.upper(), 'FOO')

    def test_isupper_DEV_124(self):
        self.assertTrue('FOO'.isupper())
        self.assertFalse('Foo'.isupper())

    def test_split_DEV_125(self):
        s = 'hello world'
        self.assertEqual(s.split(), ['hello', 'world'])
        with self.assertRaises(TypeError):
            s.split(2)

if __name__ == '__main__':
    unittest.main()

